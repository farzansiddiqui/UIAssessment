package com.siddiqui.uiassessment.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.siddiqui.uiassessment.R;
import com.siddiqui.uiassessment.databinding.ActivityMainBinding;
import com.siddiqui.uiassessment.model.UiData;
import com.siddiqui.uiassessment.viewmodel.UiViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private UiViewModel viewModel;
    TextView[] textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(UiViewModel.class);
        textViews = new TextView[5];

        setCircle();
        textViews[0] = binding.textViewSubHeader;
        textViews[1] = binding.descriptionTextView;
        textViews[2] = binding.description1TexView;
        textViews[3] = binding.description2TexView;
        textViews[4] = binding.commentTextView;


        List<MutableLiveData<String>> textViewsData = viewModel.getTextViewsData();

        for (int i = 0; i <= textViews.length; i++) {
                final int index = i;
                    textViewsData.get(i).observe(this, s -> textViews[index].setText(s));
        }

        textViewsData.get(0).setValue("지난 월요일에 했던 이벤트 중 가장 괜찮은 상품 뭐야?");
        textViewsData.get(1).setValue("지난 월요일에 2023년 S/S 트렌드 알아보기 이벤트 참석했던 팝들아~ 혹시 어떤 상품이 제일 괜찮았어?");
        textViewsData.get(2).setValue("후기 올라오는거 보면 로우라이즈? 그게 제일 반응 좋고 그 테이블이 제일 재밌었다던데 맞아???");
        textViewsData.get(3).setValue("올해 로우라이즈가 트렌드라길래 나도 도전해보고 싶은데 말라깽이가 아닌 사람들도 잘 어울릴지 너무너무 궁금해ㅜㅜ로우라이즈 테이블에 있었던 팝들 있으면 어땠는지 후기 좀 공유해주라~~!");
        textViewsData.get(4).setValue("어머 제가 있던 테이블이 제일 반응이 좋았나보네요\uD83E\uDD2D우짤래미님도 아시겠지만 저도 일반인 몸매 그 이상도 이하도아니잖아요?! 그런 제가 기꺼이 도전해봤는데 생각보다괜찮았어요! 오늘 중으로 라이브 리뷰 올라온다고 하니\n" +
                "꼭 봐주세용~!");

        viewModel.getData().observe(this, uiData -> binding.imageView.setImageResource(uiData.getImageResourceId()));
        viewModel.getData().observe(this, uiData -> binding.textViewComment.setText(uiData.getText()));

        UiData uiData = new UiData("오 대박! 라이브 리뷰 오늘 올라온대요? 챙겨봐야겠다", R.drawable.img);
        viewModel.setUiData(uiData);
    }



    private void setCircle() {
        ImageView[] imageViews = new ImageView[5];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT

        );
        layoutParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i < imageViews.length; i++) {
            imageViews[i] = new ImageView(getApplicationContext());
            imageViews[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(), R.drawable.round_circle
            ));
            imageViews[i].setLayoutParams(layoutParams);
            binding.layoutCircle.addView(imageViews[i]);
        }
    }
}