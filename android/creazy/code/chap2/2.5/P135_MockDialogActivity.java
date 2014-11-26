package creazy.chap2.section2_5;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.creazy.R;

/**
 * ���Android����:
 *  2.5.3 ʹ��AlertDialog�����Զ���Ի���(P131)
 *   ʵ��: �Ի�����Ĵ���
 * 
 * @author zjdgx
 * @since 2014-04-21
 */
public class P135_MockDialogActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p135_mock_dialog_main);
		Button btn = (Button) findViewById(R.id.p135_btn);
		
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// ������ǰActivity
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}