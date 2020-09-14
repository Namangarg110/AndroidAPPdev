package naman.killtime.mavik1;

public class words
{
    private String mDefaultTranslation;
    private String mMivokTranslation;
    private int mImageResourceId=NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED=-1;


    public words(String DefaultTranslation,String MivokTranslation, int imageResourseId)
    {
        mDefaultTranslation=DefaultTranslation;
        mMivokTranslation=MivokTranslation;
        mImageResourceId=imageResourseId;

    }
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

    public int getImageResourceIdId(){return mImageResourceId;}

    public boolean hasImage(){
        return mImageResourceId!= NO_IMAGE_PROVIDED;
    }
}
