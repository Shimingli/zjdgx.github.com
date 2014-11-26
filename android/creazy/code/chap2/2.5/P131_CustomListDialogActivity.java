package creazy.chap2.section2_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.creazy.R;

/**
 * ���Android����:
 *  2.5.3 ʹ��AlertDialog�����Զ���Ի���(P131)
 *   ʵ��: ʹ��AlertDialog�����Զ����б�Ի���
 * 
 * @author zjdgx
 * @since 2014-04-21
 */
public class P131_CustomListDialogActivity extends Activity {

	final int LIST_DIALOG = 0x113;
	// ���������б��������
	final String[] names = new String[] { "����", "����", "����" };
	// ���������б����Ӧ��ͼ��
	private int[] imageIds = new int[] { R.drawable.p131_p, R.drawable.p131_z,
			R.drawable.p131_t };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p131_custom_list_dialog_main);
		Button btn = (Button) findViewById(R.id.btn);
		final Builder builder = new AlertDialog.Builder(this);
		btn.setOnClickListener(new OnClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				showDialog(LIST_DIALOG);
			}
		});
		builder.create().show();
	}

	@Override
	public Dialog onCreateDialog(int id, Bundle state) {
		// �ж���Ҫ�����������͵ĶԻ���
		switch (id) {
		case LIST_DIALOG:
			Builder builder = new AlertDialog.Builder(this);
			// ���öԻ����ͼ��
			builder.setIcon(R.drawable.p110_red);
			// ���öԻ���ı���
			builder.setTitle("��ѡ�б�Ի���");
			List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < names.length; i++) {
				Map<String, Object> item = new HashMap<String, Object>();
				item.put("img", imageIds[i]);
				item.put("name", names[i]);
				listItems.add(item);
			}
			// ����һ��SimpleAdapter
			SimpleAdapter adapter = new SimpleAdapter(this, listItems,
					R.layout.p131_cell, new String[] { "name", "img" },
					new int[] { R.id.personName, R.id.personHeader });
			// Ϊ�Ի������ö���б�
			builder.setAdapter(adapter, new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					TextView text = (TextView) findViewById(R.id.customDialog);
					text.setText("���ó���������:" + names[which]);
				}
			});
			return builder.create();
		}
		return null;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}