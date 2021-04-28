package kaisensdata.apiemotion.myapplication;

import com.google.gson.annotations.SerializedName;

public class Reponse {

    @SerializedName("degout")
    private String degout;
    @SerializedName("colere")
    private String colere;
    @SerializedName("neutre")
    private String neutre;
    @SerializedName("joie")
    private String joie;
    @SerializedName("etonnement")
    private String etonnement;

    public Reponse(String degout, String colere, String neutre, String joie, String etonnement) {
        this.degout = degout;
        this.colere = colere;
        this.neutre = neutre;
        this.joie = joie;
        this.etonnement = etonnement;
    }

    @Override
    public String toString() {
        return "{\n  degout : "+degout+"\n  colere : "+colere+"\n  neutre : "+neutre+"\n  joie : "+joie+"\n  etonnement : "+etonnement+"\n }";
    }
}
