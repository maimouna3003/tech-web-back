package com.unchk.unchk.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unchk.unchk.models.LoginUser;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SecurityController {

        private final AuthenticationManager authenticationManager;
        private final JwtEncoder jwtEncoder;

        @PostMapping("/login")
        public Map<String, Object> postMethodName(@RequestBody LoginUser loginUser) throws Exception {
                Map<String, Object> responseData = new HashMap<>();
                try {
                        Authentication authentication = authenticationManager
                                        .authenticate(new UsernamePasswordAuthenticationToken(
                                                        loginUser.getUserEmail(),
                                                        loginUser.getPassword()));

                        String profil = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                                        .collect(Collectors.joining(" "));

                        Instant instant = Instant.now();

                        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                                        .issuedAt(instant)
                                        .expiresAt(instant.plus(30, ChronoUnit.MINUTES))
                                        .subject(loginUser.getUserEmail())
                                        .claim("scope", profil)
                                        .build();

                        JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters.from(
                                        JwsHeader.with(MacAlgorithm.HS512).build(),
                                        jwtClaimsSet);

                        responseData.put("token", jwtEncoder.encode(jwtEncoderParameters).getTokenValue());
                        responseData.put("message", "Connexion reussit");
                        responseData.put("error", null);

                        return responseData;

                } catch (Exception e) {
                        System.out.println("no acces ressource");
                }
                responseData.put("token", null);
                responseData.put("message", null);
                responseData.put("error", "Email ou mots de pass incorrect !");
                return responseData;

        }

}
