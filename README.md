# AutoAdjustmentLayout
Pre Alpha.
Android Compound View. Simple layout which takes Objects and  adjusts them according to width of item and parent layout line by line.

# H1Usage:

AutoAdjustmentLayout autoAdjustmentView = (AutoAdjustmentLayout) findViewById(R.id.autoAdjustmentView);
autoAdjustmentView.setElementList(getRandomItems(20));
  
autoAdjustmentView.setAutoAdjustmentLayoutListener(new AutoAdjustmentLayout.IOnAutoAdjustmentLayoutListener() {
          @Override
          public void onLastItemRemoved(View view) {
          
          }
          
          @Override
          public void onItemRemoved(View view) {
          
          }
        });
  }
  
  To append items dynamically:
  
  autoAdjustmentView.addElement(getTextView(156, new Random(), 2));
  autoAdjustmentView.addElements(getRandomItems(20));
