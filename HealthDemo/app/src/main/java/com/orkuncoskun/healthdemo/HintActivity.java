package com.orkuncoskun.healthdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;

import java.util.Arrays;
import java.util.Collections;

public class HintActivity extends AppCompatActivity {

    private TextView hintTextView;
    private Button hintButton;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.logout_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.logout) {

            ParseUser.logOut();

            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        hintTextView = (TextView) findViewById(R.id.hintTextiew);
        hintButton = (Button) findViewById(R.id.hintButton);

        hintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showRandomHints();

            }
        });

        showRandomHints();

        setTitle("Hint");
    }

    public void showRandomHints(){

        shuffleHints();
        hintTextView.setText(factArray[0].getmHints());

    }
    Hints h01 = new Hints("Regularly doing cardio and strength training reduces your risk of heart disease, diabetes, and endometrial, colon, and breast cancers.");
    Hints h02 = new Hints("You'll feel less stressed and happier. Exercise has been proven to improve your mood and decrease anxiety. Studies show that the fitter you are, the better you'll be at handling the long-term effects of stress.");
    Hints h03 = new Hints("It strengthens your bones. Exercise increases bone density, helping prevent osteoporosis. High-intensity activity, like jumping and running, is most beneficial for preserving bone mass.");
    Hints h04 = new Hints("Always warm up and cool down. This exercise tip will help you maintain your mobility and flexibility and prevent injury. Take 5-10 minutes to gradually raise your heart rate at the beginning of a workout and lower it afterward.");
    Hints h05 = new Hints("Don't cruise through cardio. Increase intensity by doing intervals: After a warm-up, alternate 1-2 minutes of activity at a rate of perceived exertion, or RPE, of 7 or 8 with 2-4 minutes of lower-intensity periods (RPE of 3-4).");
    Hints h06 = new Hints("Tone up on the treadmill. Save time at the gym with this 10-minute cardio/sculpt session: Hop on a treadmill holding a three- to five-pound dumbbell in each hand, and set the speed to a brisk walk. Do a 60-second set each of shoulder presses, biceps curls, triceps extensions, side laterals, front laterals and standing triceps kickbacks one after another as you walk.");
    Hints h07 = new Hints("Make over your running routine. Unless you're training for a marathon, skip long, slow, distance running-sprinting builds more muscle. Add a few 10- to 60-second sprints to your run, slowing down just long enough to catch your breath between them, says Stephen Holt, ACE personal trainer.");
    Hints h08 = new Hints("Use the talk test. If you can't speak a sentence or two with each breath, you're pushing too hard.");
    Hints h09 = new Hints("Get a jump on weight loss. Add plyometric box jumps to your workout to improve your cardiovascular stamina and leg strength - you'll really sculpt your hamstrings, quads and glutes.");
    Hints h10 = new Hints("Watch the clock to lose weight. In a Journal of the American Medical Association study, women who racked up at least 200 cardio minutes a week for 18 months lost nearly 14 percent of their total body weight.");
    Hints h11 = new Hints("Power up your runs. Adding wall sits to the end of every run will strengthen your quads, hamstrings, and glutes, improving your speed and endurance. Lean against a wall with your feet shoulder-width apart, then squat until your knees are bent at 45 degrees.");
    Hints h12 = new Hints("Lift like you mean it. If you can do the maximum number of suggested reps (usually 10-12) without feeling fatigued, add pounds (10-15 percent at a time). If you can't complete the minimum number of suggested reps (usually 8), reduce the weight in 10 percent increments until you can. Your last 1 or 2 reps should always feel tough, but doable.");
    Hints h13 = new Hints("Try this all-in-one toner. A side-step squat with wood chop works your arms, torso, abs, back, legs, inner thighs and butt, says David Kirsch, trainer and author of The Ultimate New York Body Plan.");
    Hints h14 = new Hints("Balance your body. To head off injuries, build good posture, and ensure you have strength for your favorite activities, do exercises for opposing muscle groups. During your weekly routines, if you work the quads, for example, do exercises for your hamstrings as well");
    Hints h15 = new Hints("Work out during your workday. Sit on a stability ball to strengthen your core, and keep dumbbells or exercise tubing at your desk, says Gregory Florez, personal trainer in Salt Lake City, Utah. Squeeze in 12 to 15 reps of exercises like dumbbell curls, overhead presses, and ab crunches; aim for two or three sets of each. This gives you more free time to fit in fun workouts like biking or tennis.");
    Hints h16 = new Hints("Take a day off between weight-lifting sessions. Always give muscle groups 48 hours of rest between resistance workouts to allow them time to adapt to the stress you put on them. If you must lift every day, don't target the same muscles in back-to-back sessions.");
    Hints h17 = new Hints("Super-sculpt your butt. Get great glutes by targeting the muscles and connective tissues buried deep in your body. To hit them, do high-intensity squats, such as jump squats. Then, blast off butt flab with cross-country skiing, bleacher running, and stair climbing, says Steve Ilg, author of Total Body Transformation.");
    Hints h18 = new Hints("Don't let your routine become rote. To continue to make sculpting gains, this exercise tip is crucial: Change the moves, order, weight, sets, reps and/or rest periods you do at least every four weeks. Try mixing things up more often. According to a study in the Journal of Strength and Conditioning Research, subjects who varied the number of sets and reps from workout to workout saw greater strength gains-even at the same intensity-than those who stuck to the same routine.");
    Hints h19 = new Hints("Move it like you mean it. Here's a non-exercise exercise tip: Walk like you're late for an appointment. Move quickly enough to cover a mile in 15-20 minutes-that's a moderate pace.");
    Hints h20 = new Hints("Add the bike to your ab routine. According to an American Council on Exercise study, the bicycle (lying faceup, bring right knee and left elbow toward each other, then switch sides) is the best waist-firming exercise because it uses every muscle in your abs. Prefer normal crunches? Doing them on a stability ball is more effective than doing them on the floor because your core will have to work harder to stabilize your position and you're able to move through a larger range of motion.");
    Hints h21 = new Hints("Write it down. Pick up a pen or download a journaling app for this workout tip. Experts recommend tracking your runs-the distance, route, everything! Just like keeping a food journal improves your diet, tracking your workouts helps you stick with exercise. (Here are the best free workout apps and the best free run tracking apps.)");
    Hints h22 = new Hints("Run (or walk) for the hills! You burn 25-40 percent more calories-and increase your stamina-by walking or running on inclines than you do treading on flat surfaces. Add short hills (50-100 yards) to your usual route or increase the incline on the treadmill.");
    Hints h23 = new Hints("Stay in control. Don't use momentum instead of your abs to do the work. Keep your middle muscles contracted throughout the entire range of motion.");
    Hints h24 = new Hints("Stretch to get stronger. Some research shows that stretching the muscle group you just worked between sets can increase strength gains by 19 percent. (Related: Why You Should NeverSkip a Post-Workout Cooldown)");
    Hints h25 = new Hints("Get bendy regularly. On most days post-exercise-never do it cold-stretch every muscle group you used, holding each for 30 seconds. Increasing your range of motion may make you less prone to injury during everyday activities.");


    Hints[] factArray = new Hints[] {
       h01,h02,h03,h04,h05,h06,h07,h08,h09,h10,h11,h12,h13,h14,h15,h16,h17,h18,h19,h20,h21,h22,h23,h24,h25
    };

    public void shuffleHints() {

        Collections.shuffle(Arrays.asList(factArray));

    }

}
