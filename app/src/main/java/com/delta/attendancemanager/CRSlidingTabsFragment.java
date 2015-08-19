package com.delta.attendancemanager;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HandshakeCompletedListener;

public class CRSlidingTabsFragment extends Fragment{

    MySqlHandler handler;
    List<String[]> all;
    private SlidingTabLayout mSlidingTabLayout;

    private ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weektt, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SamplePagerAdapter());

        // Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
        // it's PagerAdapter set.
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    class SamplePagerAdapter extends PagerAdapter {

        /**
         * @return the number of pages to display
         */
        @Override
        public int getCount() {
            return 5;
        }

        /**
         * @return true if the value returned from {@link #instantiateItem(ViewGroup, int)} is the
         * same object as the {@link View} added to the {@link ViewPager}.
         */
        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        /**
         * Return the title of the item at {@code position}. This is important as what this method
         * returns is what is displayed in the {@link SlidingTabLayout}.
         * <p>
         * Here we construct one using the position value, but for real application the title should
         * refer to the item's contents.
         */
        @Override
        public CharSequence getPageTitle(int position)
        {
            //return "Item " + (position + 1);

            switch(position)
            {
                case 0:
                    return "Monday";
                case 1:
                    return "Tuesday";
                case 2:
                    return "Wednesday";
                case 3:
                    return "Thursday";
                case 4:
                    return "Friday";
            }

            return null;
        }

        /**
         * Instantiate the {@link View} which should be displayed at {@code position}. Here we
         * inflate a layout from the apps resources and then change the text view to signify the position.
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            handler=new MySqlHandler(getActivity(),null);
            all=new ArrayList<>();
            all=handler.get_days();
            String[] m,t,w,th,f,x;
            m=new String[9];
            t=new String[9];
            w=new String[9];
            th=new String[9];
            f=new String[9];
            x=new String[9];
            for (String[] i : all){
                if(i[0].equals("Monday"))
                    m=i;
                else if(i[0].equals("Tuesday"))
                    t=i;
                else if(i[0].equals("Wednesday"))
                    w=i;
                else if(i[0].equals("Thursday"))
                    th=i;
                else if(i[0].equals("Friday"))
                    f=i;
            }

            // Inflate a new layout from our resources
            View view = getActivity().getLayoutInflater().inflate(R.layout.pager_item,
                    container, false);
            // Add the newly created View to the ViewPager
            container.addView(view);

            TextView sub1 = (TextView) view.findViewById(R.id.sub1);
            TextView sub2 = (TextView) view.findViewById(R.id.sub2);
            TextView sub3 = (TextView) view.findViewById(R.id.sub3);
            TextView sub4 = (TextView) view.findViewById(R.id.sub4);
            TextView sub5 = (TextView) view.findViewById(R.id.sub5);
            TextView sub6 = (TextView) view.findViewById(R.id.sub6);
            TextView sub7 = (TextView) view.findViewById(R.id.sub7);
            TextView sub8 = (TextView) view.findViewById(R.id.sub8);

            switch (position){
                case 0:
                    x=m;
                    break;
                case 1:
                    x=t;
                    break;
                case 2:
                    x=w;
                    break;
                case 3:
                    x=th;
                    break;
                case 4:
                    x=f;
                    break;
            }
            sub1.setText(x[1]);
            sub2.setText(x[2]);
            sub3.setText(x[3]);
            sub4.setText(x[4]);
            sub5.setText(x[5]);
            sub6.setText(x[6]);
            sub7.setText(x[7]);
            sub8.setText(x[8]);


            sub1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
                    //return true;
                    selectsubdialog();
                }
            });

            sub2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
                    //return true;
                    selectsubdialog();
                }
            });

            sub3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
                    //return true;
                    selectsubdialog();
                }
            });

            sub4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
                    //return true;
                    selectsubdialog();
                }
            });

            sub5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
                    //return true;
                    selectsubdialog();
                }
            });

            sub6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
                    //return true;
                    selectsubdialog();
                }
            });

            sub7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
                    //return true;
                    selectsubdialog();
                }
            });

            sub8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
                    //return true;
                    selectsubdialog();
                }
            });

            // Retrieve a TextView from the inflated View, and update it's text
            //TextView title = (TextView) view.findViewById(R.id.item_title);
            //title.setText(String.valueOf(position + 1));

            // Return the View
            return view;
        }

        public void selectsubdialog()
        {
            /* When getting the number of subjects from the api, if no ofsubjects <11, set the appropriate number of radiobutton's visibility to gone */
            final Dialog dialog = new Dialog(getActivity());
            dialog.setContentView(R.layout.edit_tt_dialog);
            dialog.setTitle("Select Subject");

            Button dialogButton = (Button) dialog.findViewById(R.id.okbutton);
            // if button is clicked, close the custom dialog
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialog.show();
        }

        /**
         * Destroy the item from the {@link ViewPager}. In our case this is simply removing the
         * {@link View}.
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

}
