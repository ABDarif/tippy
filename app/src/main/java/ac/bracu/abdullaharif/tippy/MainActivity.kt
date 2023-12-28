package ac.bracu.abdullaharif.tippy

import android.animation.ArgbEvaluator
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.content.ContextCompat

private const val INITIAL_TIP_PERCENT = 15

class MainActivity : AppCompatActivity() {
    private lateinit var etBaseAmount: EditText
    private lateinit var SeekBarTip: SeekBar
    private lateinit var tvTipPercentLabel: TextView
    private lateinit var etTipAmount: TextView
    private lateinit var etTotalAmount: TextView
    private lateinit var tvTipDescription: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etBaseAmount = findViewById(R.id.etBaseAmount)
        SeekBarTip = findViewById(R.id.SeekBarTip)
        tvTipPercentLabel = findViewById(R.id.tvTipPercentLabel)
        etTipAmount = findViewById(R.id.etTipAmount)
        etTotalAmount = findViewById(R.id.etTotalAmount)
        tvTipDescription = findViewById(R.id.tvTipDescription)

        SeekBarTip.progress = INITIAL_TIP_PERCENT
        tvTipPercentLabel.text = "$INITIAL_TIP_PERCENT%"
        updateTipDescription(INITIAL_TIP_PERCENT)

        SeekBarTip.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvTipPercentLabel.text = "$progress%"
                updateTipDescription(progress)
                printTipAndTotal()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })
        etBaseAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                printTipAndTotal()
            }

        })
    }

    private fun updateTipDescription(tipPercent: Int) {
        val tipDescription = when (tipPercent) {
            in 0..9 -> "Poor"
            in 10..14 -> "Acceptable"
            in 15..19 -> "Good"
            in 20..24 -> "Great"
            else -> "Amazing"
        }
        tvTipDescription.text = tipDescription

        val color = ArgbEvaluator().evaluate(
            tipPercent.toFloat()/SeekBarTip.max,
            ContextCompat.getColor(this, R.color.worst),
            ContextCompat.getColor(this, R.color.best)) as Int
        tvTipDescription.setTextColor(color)
    }

    @SuppressLint("SetTextI18n")
    private fun printTipAndTotal() {
        if (etBaseAmount.text.isEmpty()) {
            etTipAmount.text = ""
            etTotalAmount.text = ""
            return
        }
        // 1. Get the values of Base & Tip Percent
        val baseAmount = etBaseAmount.text.toString().toDouble()
        val tipPercent = SeekBarTip.progress
        // 2. Calculate Tip & Total
        val tipAmount = baseAmount * tipPercent / 100
        val totalAmount = baseAmount + tipAmount
        // 3. Update Tip & Total in the UI
        etTipAmount.text = "%.2f".format(tipAmount)
        etTotalAmount.text = "%.2f".format(totalAmount)
    }
}