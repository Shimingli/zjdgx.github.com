package creazy.chap2.section2_5;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.creazy.R;

/**
 * ���Android����:
 *  2.5.6 ʹ��ProgressDialog�������ȶԻ���(P139)
 *   ʵ��: ProgressDialog
 * 
 * @author zjdgx
 * @since 2014-04-22
 */
public class P139_ProgressDialogActivity extends Activity {
	
	private int[] data = new int[100];
	
	int hasData = 0;
	
	final int PROGRESS_DIALOG = 0x122;
	
	ProgressDialog progressDialog;
	
	int progressStatus = 0;
	
	Handler handler;

	@SuppressLint("HandlerLeak")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p139_progressdialog_main);

		Button execBtn = (Button) findViewById(R.id.p139_exec_btn);

		execBtn.setOnClickListener(new OnClickListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				showDialog(PROGRESS_DIALOG);
			}
		});
		handler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				if(msg.what == 0x123456) {
					progressDialog.setProgress(progressStatus);
				}
			}
		};
	}
	
	@Override
	public Dialog onCreateDialog(int id, Bundle status) {
		System.out.println("----------create start---------");
		switch(id) {
		case PROGRESS_DIALOG:
			progressDialog = new ProgressDialog(this);
			progressDialog.setMax(100);
			progressDialog.setTitle("������ɰٷֱ�");
			progressDialog.setProgress(0);//������ɰٷֱ�
			progressDialog.setMessage("��ʱ������ɰٷֱ�");//���öԻ�����ʾ������
			progressDialog.setCancelable(false);//���öԻ������á�ȡ������ť�ر�
			progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			//progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			progressDialog.setIndeterminate(false);
			break;
		}
		return progressDialog;
	}
	
	//�÷�������onCreateDialog��������֮��ص�
	@Override
	public void onPrepareDialog(int id, Dialog dialog) {
		System.out.println("----------prepare--------");
		switch (id) {
		case PROGRESS_DIALOG:
			progressDialog.setProgress(0);// �Ի����������
			//progressDialog.incrementProgressBy(-progressDialog.getProgress());
			new Thread() {
				public void run(){
					while(progressStatus < 100) {
						progressStatus = doWork();
						Message msg = new Message();
						msg.what = 0x123456;
						handler.sendMessage(msg);
					}
					if( progressStatus >= 100) {
						progressDialog.dismiss();
					}
				}
			}.start();
			break;
		}
	}
	
	public int doWork() {
		data[hasData++] = (int)(Math.random()*100);
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hasData;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}