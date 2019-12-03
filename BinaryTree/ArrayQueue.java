package Task1_BinaryTree;

class ArrayQueue implements Queue {
	public int front; 
	public int rear;
	public int count; 
	public int queueSize; 
	public int increment;
	public Object[] itemArray;

	public ArrayQueue()
	{
		front = 0;
		rear = 0;
		count = 0;
		queueSize = 50; 
		increment = 10; 
		itemArray = new Object[queueSize];
	}

	public boolean isEmpty() {
		return (count == 0);
	}

	public void enqueue(Object x)  //ť�� ���Ҹ� �����ϴ� �޼ҵ�
	{
		if (count == queueSize)	//ť�� ������� Ȯ��
			queueFull(); //��ã���� queueFull�� ������ ���� �÷���
		itemArray[rear] = x; //ť�� ��, rear�� ���� ����	
		rear = (rear + 1) % queueSize;	//����ť, ���� ������ �Ǿ����� rear�� ���� +1 �÷���
		count++;	//���� ���� ++
	}

	public void queueFull()  //ť�� ������ �� ť�� ������ �÷��ִ� �޼ҵ�
	{
		int oldsize = queueSize; //oldsize ������ ������ queuesize ����
		queueSize += increment; //���� ť ������ +10
		Object[] tempArray = new Object[queueSize];	//Ȯ��� ũ���� �ӽ� �迭	
		for (int i = 0; i < count; i++) //�ӽù迭�� ������ ���ҵ��� �̵���Ű�� �ݺ���
		{
			tempArray[i] = itemArray[front];	///�̵�
			front = (front + 1) % oldsize;	//front�� +1�� �Ű���
		}
		itemArray = tempArray;	//�迭�� ���� ����
		front = 0;	//front �ʱ�ȭ
		rear = count;	//rear�� count�� ����
	}

	public Object dequeue() //ť���� ���Ҹ� �����ϰ� ��ȯ���ִ� �޼ҵ�
	{
		if (isEmpty())	//ť�� ������� Ȯ��
			return null;	//���̻� �����Ұ� ������ null ��ȯ
		Object item = itemArray[front]; //item������ ť�� ù��° ���Ҹ� ����
		front = (front + 1) % queueSize;	//����ť, ���� ������ �Ǿ����� front�� ���� +1 ����
		count--;	//���� ���� --
		return item;	//������ ���� ��ȯ����
	}

} 
