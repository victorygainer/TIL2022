package kr.tjoeun.customer;

//	우수 고객 정보를 기억하는 클래스
//	이미 Customer 클래스에서 구현한 내용이 중복되므로 Customer를 상속(확장)받아 만든다.
public class VIPCustomer extends Customer {

//	일반 고객 정보에는 없고 우수 고객 정보에만 있는 필드를 선언한다.
//	담당 상담원이 배정된다.
	private int agentID; // 담당 상담원 ID
//	제품을 살 때 10%를 할인해주고 보너스 포인트는 5%를 적립한다.
	private double salesRatio; // 추가 할인 비율
	
	public VIPCustomer() {
//		super();
//		부모 클래스에 private 권한으로 작성된 customerGrade, bonusRatio 필드에 접근하면
//		에러가 발생된다.
//		customerGrade = "VIP"; // 에러
//		bonusRatio = 0.05; // 에러
//		부모 클래스에서 상속받은 setters 메소드를 실행해서 VIP 고객의 정보를 넣어준다.
		setCustomerGrade("VIP");
		setBonusRatio(0.05);
		salesRatio = 0.1;
	}

	public int getAgentID() {
		return agentID;
	}
	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}
	public double getSalesRatio() {
		return salesRatio;
	}
	public void setSalesRatio(double salesRatio) {
		this.salesRatio = salesRatio;
	}

//	실제 구매 금액을 계산하는 메소드
	public int calcSales(int price) {
//		return (int) (price * salesRatio); // 할인 금액
		return (int) (price * (1 - salesRatio)); // 실 구매 금액
	}
	
//	Customer 클래스에서 상속받은 calcBonus() 메소드는 구매 금액에 대한 보너스 포인트를
//	계산하기 때문에 VIP 고객의 할인율이 적용된 금액에 대한 보너스 포인트는 계산할 수 없다.
//	Customer 클래스에서 상속받은 calcBonus() 메소드를 Override 해서 구현한다.
	
//	구매 금액을 인수로 넘겨받아서 실 구매 금액에 따른 보너스 포인트를 계산하는 메소드
	@Override
	public int calcBonus(int price) {
		return (int) (calcSales(price) * getBonusRatio());
	}

}








