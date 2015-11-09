# AutoAdjustmentLayout
Pre Alpha.
Android Compound View. 
Simple layout which takes Objects of View type and adjusts them according to width of item and parent layout, line by line.
You have the ability to remove items by click.

Usage:
---- 

```java
AutoAdjustmentLayout autoAdjustmentView = (AutoAdjustmentLayout) findViewById(R.id.autoAdjustmentView);
autoAdjustmentView.setElementList(ArrayList<Object>);
autoAdjustmentView.isRemovable(true);

autoAdjustmentView.setAutoAdjustmentLayoutListener(new AutoAdjustmentLayout.IOnAutoAdjustmentLayoutListener() {
          @Override
          public void onLastItemRemoved(View view) {
          
          }
          
          @Override
          public void onItemRemoved(View view) {
          
          }
        });
  }
  ```
  
  To append items dynamically:
  
  ```java
autoAdjustmentView.addElement(Object);
autoAdjustmentView.addElementList(ArrayList<Object>);
 ```
  To remove item dynamically:
  
  ```java
autoAdjustmentView.removeElement(Object);
 ```
