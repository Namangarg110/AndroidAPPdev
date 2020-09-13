package naman.killtime.mavik1;

public class words
{
    private String mDefaultTranslation;
    private String mMivokTranslation;

    public words(String DefaultTranslation,String MivokTranslation)
    {
        mDefaultTranslation=DefaultTranslation;
        mMivokTranslation=MivokTranslation;
    }

    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public String getMivokTranslation()
    {
        return  mMivokTranslation;
    }
}
