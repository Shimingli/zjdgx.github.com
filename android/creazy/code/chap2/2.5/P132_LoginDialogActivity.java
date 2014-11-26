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
import android.widget.TableLayout;

import com.example.creazy.R;

/**
 * ���Android����:
 *  2.5.3 ʹ��AlertDialog�����Զ���Ի���(P131)
 *   ʵ��: ��¼�Ի���
 * 
 * @author zjdgx
 * @since 2014-04-21
 */
public class P132_LoginDialogActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p132_login_main_dialog_main);
		Button btn = (Button) findViewById(R.id.p132_btn);
		final Builder builder = new AlertDialog.Builder(this);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// ���öԻ����ͼ��
				builder.setIcon(R.drawable.p110_red);
				// ���öԻ���ı���
				builder.setTitle("��ѡ�б�Ի���");
				TableLayout loginForm = (TableLayout) getLayoutInflater()
						.inflate(R.layout.p132_login_dialog_main, null);
				// ���öԻ�����ʾ��view����
				builder.setView(loginForm);
				builder.setPositiveButton("��¼",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO:�����¼
							}
						});
				builder.setNegativeButton("ȡ��",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO:ȡ����¼
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