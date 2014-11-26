package creazy.chap2.section2_5;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.creazy.R;

/**
 * ���Android����:
 *  2.5.1 ʹ��AlertDialog�����򵥶Ի���(P124)
 *   ʵ��: ��ʾ��ʾ��Ϣ�ĶԻ���
 * 
 * @author zjdgx
 * @since 2014-04-18
 */
public class P125_AlertDialogActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p125_alert_dialog_main);
		Button btn = (Button)findViewById(R.id.btn);
		// ����һ��AlertDialog.Builder����
		final Builder builder = new AlertDialog.Builder(this);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// ���öԻ����ͼ��
				builder.setIcon(R.drawable.p110_red);
				// ���öԻ���ı���
				builder.setTitle("�Զ�����ͨ�Ի���");
				// ���öԻ�����ʾ������
				builder.setMessage("�򵥵���ʾ�Ի���");
				// Ϊ�Ի�������һ��"ȷ��"��ť
				builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						EditText show = (EditText)findViewById(R.id.showTime);
						show.setText("�û�������\"ȷ��\"��ť");
					}
				});
				builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						EditText show = (EditText)findViewById(R.id.showTime);
						show.setText("�û�������\"ȡ��\"��ť");
					}
				});
				builder.create().show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}