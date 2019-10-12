package com.softtek.academy.java.basics.interfaces.impl.exe;

import com.softtek.academy.java.basics.interfaces.Figure;
import com.softtek.academy.java.basics.interfaces.impl.Cilcle;
import com.softtek.academy.java.basics.interfaces.impl.Triangle;

public class FiguresExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cilcle myCircle = new Cilcle();
		myCircle.setR(5);
		myCircle.getCommonFunctionality();
		System.out.println(myCircle.getArea());
		
		Figure myFigure = new Triangle();
		myFigure.getCommonFunctionality();
		System.out.println(myFigure);
		
		Figure[] myFigures = new Figure[] {new Cilcle(), new Triangle()};
		for(Figure figure: myFigures) {
			System.out.println(figure);
		}

	}

}
