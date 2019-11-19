public class Main {
	public static void main(String[] args){
		System.out.println("Hello !");
	}
}


/*

#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: LIVRE
#------------------------------------------------------------

CREATE TABLE LIVRE(
        LIV_ID     Int  Auto_increment  NOT NULL ,
        LIV_TITRE  Varchar (255) NOT NULL ,
        LIV_AUTEUR Varchar (255) NOT NULL ,
        LIV_DATE   Date NOT NULL
	,CONSTRAINT LIVRE_PK PRIMARY KEY (LIV_ID)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: ASSOCIE
#------------------------------------------------------------

CREATE TABLE ASSOCIE(
        ASS_ID     Int  Auto_increment  NOT NULL ,
        ASS_NOM    Varchar (255) NOT NULL ,
        ASS_PRENOM Varchar (255) NOT NULL
	,CONSTRAINT ASSOCIE_PK PRIMARY KEY (ASS_ID)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: EMPRUNTE
#------------------------------------------------------------

CREATE TABLE EMPRUNTE(
        ASS_ID    Int NOT NULL ,
        LIV_ID    Int NOT NULL ,
        EMP_DEBUT Date NOT NULL ,
        EMP_FIN   Date NOT NULL
	,CONSTRAINT EMPRUNTE_PK PRIMARY KEY (ASS_ID,LIV_ID)

	,CONSTRAINT EMPRUNTE_ASSOCIE_FK FOREIGN KEY (ASS_ID) REFERENCES ASSOCIE(ASS_ID)
	,CONSTRAINT EMPRUNTE_LIVRE0_FK FOREIGN KEY (LIV_ID) REFERENCES LIVRE(LIV_ID)
)ENGINE=InnoDB;


 */