package com.bjpowercode.javase.test005;
/*���ʿ���Ȩ�����η���
 1�����ʿ���Ȩ�����η�������Ԫ�صķ��ʷ�Χ
 2�����ʿ���Ȩ�����η�������public protected ȱʡ��default�� private
 3�����ʿ���Ȩ�����η��������Σ��ࡢ��������������
 4��public����ʾ�����ģ����κ�λ�ö����Է��ʣ�private����ʾ˽�еģ�ֻ���ڱ����з���
 protected��ͬ���������п��Է��ʣ�ȱʡ��ͬ���¿��Է���
 ��ĳ������ֻϣ������ʹ�ã���protected����
 ���η���Χ��private<ȱʡ<protected<public
 */
public class Test01 {

	public static void main(String[] args) {
		User u = new User();
		System.out.println(u.i);
		System.out.println(u.j);
	}

}
