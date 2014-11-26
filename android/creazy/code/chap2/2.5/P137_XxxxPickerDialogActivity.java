package creazy.chap2.section2_5;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.creazy.R;

/**
 * ���Android����: 2.5.5 ʹ��DatePickerDialog��TimePickerDialog(P137) ʵ��:
 * DatePickerDialog��TimePickerDialog
 * 
 * @author zjdgx
 * @since 2014-04-22
 */
public class P137_XxxxPickerDialogActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p137_xxxxpickerdialog_main);

		Button dateBtn = (Button) findViewById(R.id.p137_datepicker_btn);
		Button timeBtn = (Button) findViewById(R.id.p137_timepicker_btn);

		dateBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Calendar now = Calendar.getInstance();
				new DatePickerDialog(P137_XxxxPickerDialogActivity.this,
						new DatePickerDialog.OnDateSetListener() {
							@Override
							public void onDateSet(DatePicker view, int year,
									int monthOfYear, int dayOfMonth) {
								EditText text = (EditText)findViewById(R.id.p137_editText);
								text.setText("ѡ������:"+year+"��"+(monthOfYear+1)+"��"+dayOfMonth+"��");
							}
						}, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now
								.get(Calendar.DATE)).show();

			}
		});
		
		timeBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Calendar now = Calendar.getInstance();
				new TimePickerDialog(P137_XxxxPickerDialogActivity.this, new TimePickerDialog.OnTimeSetListener() {
					@Override
					public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
						EditText text = (EditText)findViewById(R.id.p137_editText);
						text.setText("ѡ��ʱ��:"+hourOfDay+"��"+minute+"��");
					}
				}, now.get(Calendar.HOUR), now.get(Calendar.MINUTE), true).show();

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}