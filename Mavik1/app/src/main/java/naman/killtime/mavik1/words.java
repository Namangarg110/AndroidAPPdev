package naman.killtime.mavik1;

public class words
{
    private String mDefaultTranslation;
    private String mMivokTranslation;
    private int mImageResourceId=NO_IMAGE_PROVIDED;
    private  int mAudioResourceId;

    private static final int NO_IMAGE_PROVIDED=-1;


    public words(String DefaultTranslation,String MivokTranslation, int imageResourseId,int audioResourceId)
    {
        mDefaultTranslation=DefaultTranslation;
        mMivokTranslation=MivokTranslation;
        mImageResourceId=imageResourseId;
        mAudioResourceId=audioResourceId;

    }
    public words(String DefaultTranslation,String MivokTranslation,int audioResourceId)
    {
        mDefaultTranslation=DefaultTranslation;
        mMivokTranslation=MivokTranslation;
        mAudioResourceId=audioResourceId;
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

    public int getAudioResourceId() { return mAudioResourceId; }

}
