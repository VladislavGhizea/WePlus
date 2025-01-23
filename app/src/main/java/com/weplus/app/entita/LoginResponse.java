package com.weplus.app.entita;

import com.weplus.app.entita.listaEnum.Tipo;

public class LoginResponse {

    private UtenteGenerale utenteGenerale;

    public LoginResponse(UtenteGenerale utenteGenerale) {
        this.utenteGenerale= utenteGenerale;
    }

    public UtenteGenerale getUtenteGenerale() {
        return utenteGenerale;
    }
}
