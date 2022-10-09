package bubble.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import bubble.component.Bubble;
import bubble.component.Player;

// 메인스레드 - 키보드 이벤트를 처리하기 바쁘다.
// 백그라운드에서 계속 관찰
public class BackgroundPlayerService implements Runnable{

	private BufferedImage image;
	private final Player player;
	private final List<Bubble> bubbleList;
	
	// 플레이어, 버블
	public BackgroundPlayerService(Player player) {
		this.player = player;
		this.bubbleList = player.getBubbleList();
		try {
			image = ImageIO.read(new File("image/backgroundMapService.png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void run() {
		while(player.getState() == 0) {
			
			// 1. 버블 충돌 체크
			for (Bubble bubble : bubbleList) {
				if (bubble.getState() == 1) {
					if ((Math.abs(player.getX() - bubble.getX()) < 10) &&
							Math.abs(player.getY() - bubble.getY()) > 0 && Math.abs(player.getY() - bubble.getY()) < 50) {
						bubble.clearBubbled();
						break;
					}
				}
			}
			
			// 2. 벽 충돌 체크
			// 색상 확인
			Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
			// -2가 나온다는 뜻은 바닥에 색깔이 없이 흰색
			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1
					+ image.getRGB(player.getX()+50 - 10, player.getY() + 50 + 5); // -1
			
			// 바닥 충돌 확인
			if(bottomColor != -2) {
				player.setDown(false);
			}else { // -2 일때 실행 => 바닥색깔이 하얀색이라는 것
				if(!player.isUp() && !player.isDown()) {
					player.down();
				}
			}
			
			// 외벽 충돌 확인
			if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				player.setLeftWallCrash(true);
				player.setLeft(false);
			}else if(rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				player.setRightWallCrash(true);
				player.setRight(false);
			}else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
