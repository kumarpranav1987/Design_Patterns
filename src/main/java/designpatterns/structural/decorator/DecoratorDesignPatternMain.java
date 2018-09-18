package designpatterns.structural.decorator;

/**
 * 
 * Intent Attach additional responsibilities to an object dynamically.
 * Decorators provide a flexible alternative to subclassing for extending
 * functionality.
 *
 */
public class DecoratorDesignPatternMain {

	public static void main(String[] args) {
		Widget boldborderScrollableTextBox = new BoldBorderDecorator(new ScrollDecorator(new TextBox(10, 5)));
		boldborderScrollableTextBox.draw();
	}

}

interface Widget {
	public void draw();
}

class TextBox implements Widget {
	private int height;
	private int width;

	public TextBox(int height, int width) {
		this.height = height;
		this.width = width;
	}

	@Override
	public void draw() {
		System.out.println("TextBox Drawn" + "Height=" + height + "Width=" + width);

	}
}

abstract class TextBoxDecrator implements Widget {
	private Widget widget;

	public TextBoxDecrator(Widget widget) {
		this.widget = widget;
	}

	@Override
	public void draw() {
		widget.draw();
	}
}

class BoldBorderDecorator extends TextBoxDecrator {

	public BoldBorderDecorator(Widget widget) {
		super(widget);
	}

	@Override
	public void draw() {
		super.draw();
		System.out.println("Bold Border Added");
	}
}

class ScrollDecorator extends TextBoxDecrator {

	public ScrollDecorator(Widget widget) {
		super(widget);
	}

	@Override
	public void draw() {
		super.draw();
		System.out.println("Scroll Bar Addded");
	}
}