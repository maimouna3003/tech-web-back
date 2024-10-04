package com.unchk.unchk.env;

import org.springframework.stereotype.Service;

@Service

public class CustomeHelper {
    public static String msgErrorServer500 = "Une erreur c'est produite !";
    public static String msgErrorNotFound404 = "Ce enregistrement n'existe pas !";
    public static String msgErrorNotAuth401 = "Email ou mots de pass incorrect !";
}
