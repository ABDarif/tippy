package ac.bracu.abdullaharif.tippy

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

private const val INITIAL_TIP_PERCENT = 15
class MainActivity : AppCompatActivity() {
    private lateinit var etBaseAmount: EditText
    private lateinit var SeekBarTip: SeekBar
    private lateinit var tvTipPercentLabel: TextView
    private lateinit var etTipAmount: TextView
    private lateinit var etTotalAmount: TextView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etBaseAmount = findViewById(R.id.etBaseAmount)
        SeekBarTip = findViewById(R.id.SeekBarTip)
        tvTipPercentLabel = findViewById(R.id.tvTipPercentLabel)
        etTipAmount = findViewById(R.id.etTipAmount)
        etTotalAmount = findViewById(R.id.etTotalAmount)

        SeekBarTip.progress = INITIAL_TIP_PERCENT
        tvTipPercentLabel.text = "$INITIAL_TIP_PERCENT%"

        SeekBarTip.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvTipPercentLabel.text = "$progress%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })
    }
}