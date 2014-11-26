package creazy.chap2.section2_5;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.creazy.R;

/**
 * ���Android����:
 *  2.5.4 ʹ��PopupWindow(P136)
 *   ʵ��: PopupWindow
 * 
 * @author zjdgx
 * @since 2014-04-21
 */
public class P136_PopupWindowActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p136_popup_window_main);
		
		View view = this.getLayoutInflater().inflate(R.layout.p136_popup_window, null);
		
		final PopupWindow popup = new PopupWindow(view, 280, 360);
		
		Button btn = (Button) findViewById(R.id.p136_btn);
		
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// ��������ʽ��ʾ
				popup.showAsDropDown(v);
				// ��PopupWindow��ʾ��ָ��λ��
				popup.showAtLocation(findViewById(R.id.p136_btn), Gravity.CENTER, 20, 20);
			}
		});
		// ��ȡPopupWindow�����еĹرհ�ť
		view.findViewById(R.id.p136_close).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// �ر�PopupWindow
				popup.dismiss();// ���١�����PopupWindow����
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}