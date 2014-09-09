package model;



public class ArticleIsNull extends Exception {
    @SuppressWarnings("compatibility:-4986449520535516593")
    private static final long serialVersionUID = 1L;
    private String art_str;

    public void setArt_str(String art_str) {
        this.art_str = art_str;
    }

    public String getArt_str() {
        return art_str;
    }
    
    public ArticleIsNull (String ar) {
        setArt_str(ar);
    }
    
    public String toString(){
        return "Article zatrat cannot be null or zero!" ;
    }
}
