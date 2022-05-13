package com.example.withub.loginFragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.withub.MyApp
import com.example.withub.R


class GetTokenFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.gettoken_fragment, container, false)
        val tokenReceiveBtn = view.findViewById<Button>(R.id.github_token_receive_btn_gettoken)
        val githubTokenText = view.findViewById<EditText>(R.id.github_token_paste_edittext_gettoken)
        val nextBtn = view.findViewById<Button>(R.id.next_btn_gettoken)
        tokenReceiveBtn.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://github.com/settings/tokens")
            startActivity(intent)
        }

        nextBtn.setOnClickListener{
            MyApp.prefs.githubToken = githubTokenText.text.toString()
            parentFragmentManager.beginTransaction().replace(R.id.fragmentArea, GitHubRepositoryAddFragment())
                .commit()
        }
        nextBtnActivate(githubTokenText,nextBtn)
        return view
    }

    private fun nextBtnActivate(githubTokenText:EditText, nextBtn:Button) {
        githubTokenText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (githubTokenText.text.toString().isNotEmpty()) {
                    nextBtn.setBackgroundResource(R.drawable.login_btn)
                    nextBtn.isEnabled = true
                } else {
                    nextBtn.setBackgroundResource(R.drawable.disabled_button)
                    nextBtn.isEnabled = false
                }
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }


}