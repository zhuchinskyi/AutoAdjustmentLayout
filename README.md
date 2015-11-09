# AutoAdjustmentLayout
Alpha.
Android Custom View. 
Simple layout which takes Objects of View type and adjusts them according to width of item and parent layout, line by line.

![alt tag](https://raw.github.com/zhuchinskyi/AutoAdjustmentLayout/master/smart_screen.png)

Features:
---
- set/add item(s)
- remove item dynamically
- receive callbacks (item has been removed & end achived)

Usage:
---- 

```java
AutoAdjustmentLayout autoAdjustmentView = (AutoAdjustmentLayout) findViewById(R.id.autoAdjustmentView);
autoAdjustmentView.setElementList(ArrayList<Object>);
autoAdjustmentView.isRemovable(true);

autoAdjustmentView.setAutoAdjustmentLayoutListener(new AutoAdjustmentLayout.IOnAutoAdjustmentLayoutListener() {
          @Override
          public void onItemRemoved(View view) {
          
          }
          @Override
          public void onLastItemRemoved(View view) {
          
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
