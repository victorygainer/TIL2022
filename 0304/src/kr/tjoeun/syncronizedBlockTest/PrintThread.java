package kr.tjoeun.syncronizedBlockTest;

public class PrintThread extends Thread {

	ShareArea shareArea = new ShareArea();
	
	public PrintThread() { }
	public PrintThread(ShareArea shareArea) {
		this.shareArea = shareArea;
	}
	
	public ShareArea getShareArea() {
		return shareArea;
	}
	public void setShareArea(ShareArea shareArea) {
		this.shareArea = shareArea;
	}
	
	@Override
	public void run() {
		
		synchronized (shareArea) {
			
			for (int i=0; i<3; i++) {
				int sum = shareArea.lee.money + shareArea.hong.money;
				System.out.println("예금 합계: " + sum);
				try { sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
			}
			
		}
		
		
	}
	
}










