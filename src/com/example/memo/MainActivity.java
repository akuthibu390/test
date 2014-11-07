package com.example.memo;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	//EditText用の変数
	private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //テキストを入力するEditTextをeditTextにセット
        editText=(EditText)findViewById(R.id.editText1);
    }
        //呼び出す
        public void load(View view){
        	//memoという設定ファイルを取ってくる
        	SharedPreferences prefs=getSharedPreferences("memo",Context.MODE_PRIVATE);
        	//その中のmemoという項目の文字を取ってくる
        	editText.setText(prefs.getString("memo",""));
        }
        
        //保存する
        public void save(View view){
        //memoという設定ファイルを取ってくる
        SharedPreferences prefs = getSharedPreferences("memo",Context.MODE_PRIVATE);
        //編集用に開く
        SharedPreferences.Editor editor = prefs.edit();
        //memoという項目に貼り付ける
        editor.putString("memo",editText.getText().toString());
        //保存する
        editor.commit();



        /*if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();*/
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
