package com.example.creazy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher.ViewFactory;

/**
 * ���Android����:
 *  2.4.11 ������ͼ(GridView)��ͼ���л���(ImageSwitcher)�Ĺ��ܺ��÷�(P118)
 *   ʵ��: ��Ԥ����ͼƬ�����
 * 
 * @author zjdgx
 * @since 2014-04-17
 */
public class P119_GridViewActivity extends Activity {

	int[] imageIds = new int[] {
			R.drawable.p119_bomb5,R.drawable.p119_bomb6,R.drawable.p119_bomb7,
			R.drawable.p119_bomb8,R.drawable.p119_bomb9,R.drawable.p119_bomb10,
			R.drawable.p119_bomb11,R.drawable.p119_bomb12,R.drawable.p119_bomb13,
			R.drawable.p119_bomb14,R.drawable.p119_bomb15,R.drawable.p119_bomb16,
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p119_gridview_imageswitcher_activity_main);
		// ����һ��List����
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < imageIds.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("image", imageIds[i]);
			listItems.add(item);
		}
		// ��ȡ��ʾͼƬ��ImageSwitcher
		final ImageSwitcher switcher = (ImageSwitcher) findViewById(R.id.switcher);
		// ����ͼƬ��ʾ�Ķ���Ч��
		switcher.setInAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in));
		switcher.setOutAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_out));
		// ΪImageSwitcher����ͼƬ�л��Ķ���Ч��
		/*switcher.setFactory(new ViewFactory() {
			@Override
			public View makeView() {
				ImageView imageView = new ImageView(P119_GridViewActivity.this);
				imageView.setBackgroundColor(0xff0000);
				imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
				imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
				return imageView;
			}
		});*/
		
		//����һ��SimpleAdapter
		SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.p119_cell, new String[]{"image"}, new int[]{R.id.image1});
		GridView gView = (GridView)findViewById(R.id.gridview);
		gView.setAdapter(adapter);
		gView.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				switcher.setImageResource(imageIds[position%imageIds.length]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {}
			
		});
		/*gView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// ��ʾ�������ͼƬ
				switcher.setImageResource(imageIds[position%imageIds.length]);
			}
		});*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}