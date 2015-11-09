# AutoAdjustmentLayout (Alpha)

Android Custom View. Allow to set List of Objects (extends of View) that will be placed one-by-one before the transfer to next line, depending on item and parent layout width.

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
