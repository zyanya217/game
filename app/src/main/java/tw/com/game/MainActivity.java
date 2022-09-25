package tw.com.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity
{
    // 減少魔術數字
    final int SCISSORS = 0;  // 代表剪刀的常數
    final int STONE = 1;     // 代表石頭的常數
    final int PAPER = 2;     // 代表布的常數

    TextView txtPlayer; // 顯示玩家出了什麼拳
    TextView txtPc;     // 顯示電腦出了什麼拳
    TextView txtResult; // 顯示遊戲輸贏結果

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 把layout內的TextView元件關聯到程式碼裡
        txtPlayer = (TextView)findViewById(R.id.txtPlayer);
        txtPc = (TextView)findViewById(R.id.txtPc);
        txtResult = (TextView)findViewById(R.id.txtResult);

        // 將layout內的Button元件關聯到程式碼裡
        Button btnScissors = (Button)findViewById(R.id.btnScissors);
        Button btnStone = (Button)findViewById(R.id.btnStone);
        Button btnPaper = (Button)findViewById(R.id.btnPaper);

        // 設定按鈕事件處理傾聽器
        btnScissors.setOnClickListener(btnScissorClickListener);
        btnStone.setOnClickListener(btnStoneClickListener);
        btnPaper.setOnClickListener(btnPaperClickListener);
    }

    // 剪刀按鈕事件傾聽器
    OnClickListener btnScissorClickListener = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            // Math.random()會產生一個0~1但不會等於1的隨機小數
            //  0.54 * 10 = 5.4 = (5)
            //  0.999999999999999999 * 10 = 9.999999999999 = 9
            //  0.000000000000000001 * 10 = 0.000000000001 = 0

            int pc = (int)(Math.random() * 3); // 產生0~2之間的隨機整數
            // (int)(Math.random() * 55); // 產生0~54之間的隨機整數
            // (int)(Math.random() * 91) + 9;  // 產生9~99之間的隨機整數
            //                                 // 產生5~55之間的隨機整數

            txtPlayer.setText(R.string.btnScissors);

            if(pc == 0)
            {
                txtPc.setText(R.string.btnScissors);
                txtResult.setText(R.string.txtDraw);
            }

            if(pc == 1)
            {
                txtPc.setText(R.string.btnStone);
                txtResult.setText(R.string.txtPcWin);
            }

            if(pc == 2)
            {
                txtPc.setText(R.string.btnPaper);
                txtResult.setText(R.string.txtPlayerWin);
            }
        }
    };

    // 石頭按鈕事件傾聽器
    OnClickListener btnStoneClickListener = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            int pc = (int)(Math.random() * 3); // 產生0~2之間的隨機整數

            txtPlayer.setText(R.string.btnStone);

            if(pc == 0)
            {
                txtPc.setText(R.string.btnScissors);
                txtResult.setText(R.string.txtPlayerWin);
            }

            if(pc == 1)
            {
                txtPc.setText(R.string.btnStone);
                txtResult.setText(R.string.txtDraw);
            }

            if(pc == 2)
            {
                txtPc.setText(R.string.btnPaper);
                txtResult.setText(R.string.txtPcWin);
            }
        }
    };

    // 布按鈕事件傾聽器
    OnClickListener btnPaperClickListener = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            int pc = (int)(Math.random() * 3); // 產生0~2之間的隨機整數

            txtPlayer.setText(R.string.btnPaper);

            if(pc == 0)
            {
                txtPc.setText(R.string.btnScissors);
                txtResult.setText(R.string.txtPcWin);
            }

            if(pc == 1)
            {
                txtPc.setText(R.string.btnStone);
                txtResult.setText(R.string.txtPlayerWin);
            }

            if(pc == 2)
            {
                txtPc.setText(R.string.btnPaper);
                txtResult.setText(R.string.txtDraw);
            }
        }
    };

//    // 此範例沒用到，可以不理它或移除
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    // 此範例沒用到，可以不理它或移除
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item)
//    {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings)
//        {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
