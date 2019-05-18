//******************************************************
// BMI Calculator and Table
// Author: RParkerE
// Date: 04/21/2015
//******************************************************

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class BMICalculator extends JFrame implements Runnable
{
  JMenuBar mbar;
  JScrollPane pane;
  DefaultTableModel model; 
  JTable table;
  boolean ascending;
  String col[] = {"Last","First","Height","Weight","BMI"};
  ArrayList<Person> tmp;
  List<Person> al;
  public BMICalculator()
  {
    ascending = true;
    tmp = new ArrayList<Person>();
    al = new ArrayList<Person>();
    al.add(new Person("User", "New", 74, 180));;
  }
  public void run()
  {
    model = new DefaultTableModel(col,al.size())
    {
      @Override 
      public boolean isCellEditable(int arg0, int arg1) 
      { 
        return false; 
      }
    }; 
    table = new JTable(model);
    table.getTableHeader().setReorderingAllowed(false);
    pane = new JScrollPane(table); 
    add(pane);
    makeMenu();
    makeTable();
    setVisible(true); 
    setSize(500,400); 
    setLayout(new GridLayout()); 
    setDefaultCloseOperation(EXIT_ON_CLOSE); 
  }
  public void makeMenu()
  {
    mbar = new JMenuBar();
    setJMenuBar(mbar);
    JMenu sort = new JMenu("sort");
    mbar.add(sort);
    JMenuItem last = new JMenuItem("Last Name");
    sort.add(last);
    last.addActionListener( e -> {
      if(ascending)
      {
        Collections.sort(al);
      }
      else
      {
        Collections.sort(al);
        Collections.reverse(al);
      }
      makeTable();
    });
    JMenuItem first = new JMenuItem("First Name");
    sort.add(first);
    first.addActionListener( e -> {
      if(ascending)
      {
        Comparator<Person> firstFirst = (n0, n1) ->
        {
          if( !(n0.first.equalsIgnoreCase(n1.first)))
          {
            return n0.first.compareToIgnoreCase(n1.first);
          }
          return n0.last.compareToIgnoreCase(n1.last);
        };
        Collections.sort(al, firstFirst);
      }
      else
      {
        Comparator<Person> firstFirst = (n0, n1) ->
        {
          if( !(n1.first.equalsIgnoreCase(n0.first)))
          {
            return n1.first.compareToIgnoreCase(n0.first);
          }
          return n1.last.compareToIgnoreCase(n0.last);
        };
        Collections.sort(al, firstFirst);
      }
      makeTable();
    });
    JMenuItem height = new JMenuItem("Height");
    sort.add(height);
    height.addActionListener( e -> {
      if(ascending)
      {
        Comparator<Person> heightFirst = (n0, n1) ->
        {
          if( !(n0.height == n1.height))
          {
            return n0.height- n1.height;
          }
          else if ( !(n0.last.equalsIgnoreCase(n1.last)))
          {
            return n0.last.compareToIgnoreCase(n1.last);
          }
          return n0.first.compareToIgnoreCase(n1.first);
        };
        Collections.sort(al, heightFirst);
      }
      else
      {
        Comparator<Person> heightFirst = (n0, n1) ->
        {
          if( !(n1.height == n0.height))
          {
            return n1.height- n0.height;
          }
          else if ( !(n1.last.equalsIgnoreCase(n0.last)))
          {
            return n1.last.compareToIgnoreCase(n0.last);
          }
          return n1.first.compareToIgnoreCase(n0.first);
        };
        Collections.sort(al, heightFirst);
      }
      makeTable();
    });
    JMenuItem weight = new JMenuItem("Weight");
    sort.add(weight);
    weight.addActionListener( e -> {
      if(ascending)
      {
        Comparator<Person> weightFirst = (n0, n1) ->
        {
          if( !(n0.weight == n1.weight))
          {
            return n0.weight- n1.weight;
          }
          else if ( !(n0.last.equalsIgnoreCase(n1.last)))
          {
            return n0.last.compareToIgnoreCase(n1.last);
          }
          return n0.first.compareToIgnoreCase(n1.first);
        };
        Collections.sort(al, weightFirst);
      }
      else
      {
        Comparator<Person> weightFirst = (n0, n1) ->
        {
          if( !(n1.weight == n0.weight))
          {
            return n1.weight- n0.weight;
          }
          else if ( !(n1.last.equalsIgnoreCase(n0.last)))
          {
            return n1.last.compareToIgnoreCase(n0.last);
          }
          return n1.first.compareToIgnoreCase(n0.first);
        };
        Collections.sort(al, weightFirst);
      }
      makeTable();
    });
    JMenuItem bmi = new JMenuItem("BMI");
    sort.add(bmi);
    bmi.addActionListener( e -> {
      if(ascending)
      {
        Comparator<Person> weightFirst = (n0, n1) ->
        {
          if( !(n0.bmi == n1.bmi))
          {
            return n0.bmi- n1.bmi;
          }
          else if ( !(n0.last.equalsIgnoreCase(n1.last)))
          {
            return n0.last.compareToIgnoreCase(n1.last);
          }
          return n0.first.compareToIgnoreCase(n1.first);
        };
        Collections.sort(al, weightFirst);
      }
      else
      {
        Comparator<Person> weightFirst = (n0, n1) ->
        {
          if( !(n1.bmi == n0.bmi))
          {
            return n1.bmi- n0.bmi;
          }
          else if ( !(n1.last.equalsIgnoreCase(n0.last)))
          {
            return n1.last.compareToIgnoreCase(n0.last);
          }
          return n1.first.compareToIgnoreCase(n0.first);
        };
        Collections.sort(al, weightFirst);
      }
      makeTable();
    });
    JMenuItem way = new JMenuItem("Ascending");
    mbar.add(way);
    way.addActionListener( e -> {
      ascending = !ascending;
      if(ascending)
      {
        way.setText("Ascending");
      }
      else {
        way.setText("Descending");
      }
    });
    JMenuItem add = new JMenuItem("Add");
    mbar.add(add);
    add.addActionListener( e -> {
      JFrame f = new JFrame();
      JPanel p = new JPanel(new BorderLayout(5,5));
      JPanel labels = new JPanel(new GridLayout(0,1,2,4));
      labels.add(new JLabel("Last Name", SwingConstants.RIGHT));
      labels.add(new JLabel("First Name", SwingConstants.RIGHT));
      labels.add(new JLabel("Height (in.)", SwingConstants.RIGHT));
      labels.add(new JLabel("Weight (lbs.)", SwingConstants.RIGHT));
      p.add(labels, BorderLayout.WEST);
      JPanel controls = new JPanel(new GridLayout(0,1,2,2));
      JTextField lastName = new JTextField("Doe");
      controls.add(lastName);
      JTextField firstName = new JTextField("John");
      controls.add(firstName);
      JTextField newHeight = new JTextField("70");
      controls.add(newHeight);
      JTextField newWeight = new JTextField("180");
      controls.add(newWeight);
      p.add(controls, BorderLayout.CENTER);
      f.add(p);
      f.setSize(500,500);
      f.setVisible(true);
       int returnVal = JOptionPane.showConfirmDialog(
            f, p, "ADD", JOptionPane.YES_NO_OPTION);
       if (returnVal == JOptionPane.OK_OPTION) {
         f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
         String lastN = lastName.getText();
         lastN = lastN.substring(0, 1).toUpperCase() + lastN.substring(1).toLowerCase();
         String firstN = firstName.getText();
         firstN = firstN.substring(0, 1).toUpperCase() + firstN.substring(1).toLowerCase();
         int nHeight = Integer.parseInt(newHeight.getText());
         int nWeight = Integer.parseInt(newWeight.getText());
         al.add(new Person(lastN, firstN, nHeight, nWeight));
         model.addRow(new Object[]{null, null, null, null, null});
         makeTable();
      }
      if(returnVal == JOptionPane.NO_OPTION){
        f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
    }
      if(returnVal == JOptionPane.CLOSED_OPTION){
        f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
    }
    });
    JMenuItem remove = new JMenuItem("Remove");
    mbar.add(remove);
    remove.addActionListener( e -> {
      int[] rows = table.getSelectedRows();
      List<Integer> modelRows = new ArrayList<Integer>(rows.length);     
      for (int row: rows)
      {
        int modelRow = table.convertRowIndexToModel( row );
        modelRows.add( new Integer(modelRow) );
      }
      Collections.sort(modelRows, Collections.reverseOrder());
      DefaultTableModel model = (DefaultTableModel)table.getModel();
      for (Integer row: modelRows)
      {
        al.remove(table.getSelectedRow());
        model.removeRow(row);
      }
    });
  }
  public void makeTable() 
  {
    int k = 0;
    for(Person p:al)
    {
      table.setValueAt(p.getLast(),k,0);
      table.setValueAt(p.getFirst(),k,1);
      table.setValueAt(p.getHeight(),k,2);
      table.setValueAt(p.getWeight(),k,3);
      table.setValueAt(p.getBMI(),k,4);
      k++;
    }
  }
  public static void main(String[] args) {
    BMICalculator bc = new BMICalculator();
    javax.swing.SwingUtilities.invokeLater(bc);
  }
  public class Person implements Comparable<Person>
  {
    private String last, first;
    private int height, weight, bmi;
    public Person(String _l, String _f, int _h, int _w)
    {
      last = _l;
      first = _f;
      height = _h;
      weight = _w;
      bmi = (_w*703)/(_h*_h);
    }
    public int compareTo(Person that)
    {
      if( !(last.equalsIgnoreCase(that.last)))
      {
        return last.compareToIgnoreCase(that.last);
      }
      return first.compareToIgnoreCase(that.first);
    }
    public boolean equals(Object o)
    {
      if( !(o instanceof Person))
      {
        return false;
      }
      Person that = (Person) o;
      return that.first.equalsIgnoreCase(first)
        && that.last.equalsIgnoreCase(last);
    }
    public String getLast()
    {
      return last;
    }
    public String getFirst()
    {
      return first;
    }
    public int getHeight()
    {
      return height;
    }
    public int getWeight()
    {
      return weight;
    }
    public int getBMI()
    {
      return bmi;
    }
  }
}
