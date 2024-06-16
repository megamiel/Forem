package forem.java.ui;

import forem.java.functionalInterfaces.ForemNullarySetter;

public class ForemAlert {
    public String title = "";
    String yesText = "yes";
    String noText = "no";
    ForemNullarySetter onYes = () -> {
    };
    ForemNullarySetter onNo = () -> {
    };

    public void yesButton(ForemNullarySetter onYes){
        this.onYes=onYes;
    }

    public void yesButton(String yesText,ForemNullarySetter onYes){
        this.yesText=yesText;
        this.onYes=onYes;
    }

    public void noButton(ForemNullarySetter onNo){
        this.onNo=onNo;
    }

    public void noButton(String noText,ForemNullarySetter onNo){
        this.noText=noText;
        this.onNo=onNo;
    }
}
