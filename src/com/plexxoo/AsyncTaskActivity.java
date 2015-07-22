package com.plexxoo;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AsyncTaskActivity 
extends Activity {
	private static ProgressBar progress;

	
/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		progress = (ProgressBar) findViewById(R.id.progressBar1);
	}
	static public class MiProgreso
	extends AsyncTask<Void,Integer,Void>{
		@Override
		protected void onProgressUpdate(
				Integer... ente){
			progress.setProgress(ente[0]);
		}
		@Override
		protected void onPreExecute(){
			progress.setProgress(0);
		}
		@Override
		protected Void doInBackground(Void... params) {
			for(int i=0;i<100;i++){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				publishProgress(new Integer[]{i});
			}
			return null;
		}
		@Override 
		protected void onPostExecute(Void v){
			
		}
	}
	public void startProgress(View view) {
		MiProgreso progreso=new MiProgreso();
		progreso.execute();
	
	}
}