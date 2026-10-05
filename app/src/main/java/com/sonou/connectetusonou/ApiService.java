package com.sonou.connectetusonou;

import retrofit2.http.*;
public interface ApiService<ModInscription, call> {
   @FormUrlEncoded
    call<ModInscription>execInscription(@field("nom")String nom,
                                        @field("prenom")String prenom,
                                        @field("nom")String sexe,
                                        @field("login")String login,
                                        @field("motpasse")String motpasse,
                                        @field("confmdp")String confmdp ;


    Explain Code
}
