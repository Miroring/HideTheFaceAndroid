package cin.ufpe.br.service;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.objdetect.CascadeClassifier;

import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;
import java.util.List;

import br.ufc.mdcc.mpos.util.TaskResultAdapter;
import cin.ufpe.br.Interfaces.BlurImage;
import cin.ufpe.br.Interfaces.CloudletDetectFaces;
import cin.ufpe.br.Interfaces.CutImage;
import cin.ufpe.br.Interfaces.DetectFaces;
import cin.ufpe.br.Interfaces.Overlay;
import cin.ufpe.br.model.PropriedadesFace;

/**
 * Created by eduardo on 31/10/2016.
 */

public final class MainServiceNuvem extends AsyncTask<Void, String, Bitmap> {

    private String TAG = "teste";
    public int faces;
    byte[] originalImage;
    DetectFaces serviceExtractFaces;
    BlurImage serviceBlur;
    CutImage serviceCrop;
    Overlay serviceOverlay;
    String cascadeClassifier;
    TaskResultAdapter taskResultAdapter;
    Bitmap result;
    private DecimalFormat precision = new DecimalFormat("0.0000");

    public MainServiceNuvem(byte[] originalImage, DetectFaces serviceExtractFaces, BlurImage serviceBlur, CutImage serviceCrop, Overlay serviceOverlay, String cascadeClassifier, TaskResultAdapter taskAdapter){
        this.originalImage=originalImage;
        this.serviceBlur=serviceBlur;
        this.serviceCrop=serviceCrop;
        this.serviceExtractFaces=serviceExtractFaces;
        this.serviceOverlay = serviceOverlay;
        this.cascadeClassifier=cascadeClassifier;
        taskResultAdapter=taskAdapter;
    }

    protected Bitmap doInBackground(Void... params) {
        result=begin();
        return result;
    }

    protected void onPostExecute(Bitmap result) {
        taskResultAdapter.completedTask(result);
    }

    public Bitmap begin(){
        Log.d(TAG, "\nRunning FaceDetector");
        Mat mat = new Mat();
        List<PropriedadesFace> propsFaces=null;

        //obtem os dados de onde estão as faces (altura, largura, posição x e y)
        PropriedadesFace b = serviceExtractFaces.detectarFaces(this.cascadeClassifier, this.originalImage);
        faces = b.getFaces();
        Bitmap ret = BitmapFactory.decodeByteArray(b.getImagemFinal(),0,b.getImagemFinal().length);
        return ret;
    }

    public int getNumFaces(){
        return faces;
    }

}
