package creazy.chap2.section2_7;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;
import android.widget.Toast;

import com.example.creazy.R;

/**
 * ���Android����:
 *  2.6.2 Notification�Ĺ������÷�(P143)
 *   ʵ��: Notification�ķ�����ȡ��
 * 
 * @author zjdgx
 * @since 2014-04-23
 */
public class P147_MenuActivity extends Activity {
	
	// ���������С�˵���ı�ʶ
	final int FONT_10 = 0x111;
	final int FONT_12 = 0x112;
	final int FONT_14 = 0x113;
	final int FONT_16 = 0x114;
	final int FONT_18 = 0x115;
	
	// ������ͨ�˵���ı�ʶ
	final int PLAIN_ITEM = 0x11b;
	
	// ����������ɫ�˵���ı�ʶ
	final int FONT_RED = 0x116;
	final int FONT_BLUE = 0x117;
	final int FONT_GREEN = 0x118;
	
	private EditText edit;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p147_menu_main);
		
		edit = (EditText)findViewById(R.id.p147_menu_edit);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// ------------------- ��menu����������С���Ӳ˵� -------------------
		SubMenu fontMenu = menu.addSubMenu("�����С");
		// ���ò˵���ͷ��
		fontMenu.setIcon(R.drawable.p147_font_icon);
		// ���ò˵�ͷ��ͼ��
		fontMenu.setHeaderIcon(R.drawable.p147_font_icon);
		// ���ò˵�ͷ�ı���
		fontMenu.setHeaderTitle("ѡ�������С");
		fontMenu.add(0, FONT_10, 0, "10������");
		fontMenu.add(0, FONT_12, 0, "12������");
		fontMenu.add(0, FONT_14, 0, "14������");
		fontMenu.add(0, FONT_16, 0, "16������");
		fontMenu.add(0, FONT_18, 0, "18������");
		// ------------------- ��menu�������ͨ�˵��� -------------------
		menu.add(0, PLAIN_ITEM, 0, "��ͨ�˵���");
		// ------------------- ��menu�����������ɫ���Ӳ˵� -------------------
		SubMenu colorMenu = menu.addSubMenu("������ɫ");
		// ���ò˵���ͷ��
		colorMenu.setIcon(R.drawable.p147_font_icon);
		// ���ò˵�ͷ��ͼ��
		colorMenu.setHeaderIcon(R.drawable.p147_font_icon);
		// ���ò˵�ͷ�ı���
		colorMenu.setHeaderTitle("ѡ��������ɫ");
		colorMenu.add(0, FONT_RED, 0, "��ɫ");
		colorMenu.add(0, FONT_BLUE, 0, "��ɫ");
		colorMenu.add(0, FONT_GREEN, 0, "��ɫ");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem mi) {
		edit.setText("ѡ������...");
		switch(mi.getItemId()) {
		case FONT_10:
			edit.setTextSize(10*2);
			break;
		case FONT_12:
			edit.setTextSize(12*2);
			break;
		case FONT_14:
			edit.setTextSize(14*2);
			break;
		case FONT_16:
			edit.setTextSize(16*2);
			break;
		case FONT_18:
			edit.setTextSize(18*2);
			break;
		case FONT_RED:
			edit.setTextColor(Color.RED);
			break;
		case FONT_BLUE:
			edit.setTextColor(Color.BLUE);
			break;
		case FONT_GREEN:
			edit.setTextColor(Color.GREEN);
			break;
		case PLAIN_ITEM:
			Toast toast = Toast.makeText(P147_MenuActivity.this, "��������ͨ�˵���", Toast.LENGTH_LONG);
			toast.show();
			break;	
		}
		return true;
	}

}