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

	public void enqueue(Object x)  //큐에 원소를 삽입하는 메소드
	{
		if (count == queueSize)	//큐의 저장공간 확인
			queueFull(); //꽉찾으면 queueFull로 보내서 공간 늘려줌
		itemArray[rear] = x; //큐의 끝, rear에 원소 삽입	
		rear = (rear + 1) % queueSize;	//원형큐, 원소 삽입이 되었으니 rear의 값을 +1 늘려줌
		count++;	//원소 갯수 ++
	}

	public void queueFull()  //큐가 꽉찻을 때 큐의 공간을 늘려주는 메소드
	{
		int oldsize = queueSize; //oldsize 변수에 기존의 queuesize 저장
		queueSize += increment; //기존 큐 사이즈 +10
		Object[] tempArray = new Object[queueSize];	//확장된 크기의 임시 배열	
		for (int i = 0; i < count; i++) //임시배열에 기존의 원소들을 이동시키는 반복문
		{
			tempArray[i] = itemArray[front];	///이동
			front = (front + 1) % oldsize;	//front값 +1로 옮겨줌
		}
		itemArray = tempArray;	//배열의 참조 변경
		front = 0;	//front 초기화
		rear = count;	//rear값 count에 맞춤
	}

	public Object dequeue() //큐에서 원소를 삭제하고 반환해주는 메소드
	{
		if (isEmpty())	//큐의 저장공간 확인
			return null;	//더이상 삭제할게 없으면 null 반환
		Object item = itemArray[front]; //item변수에 큐의 첫번째 원소를 저장
		front = (front + 1) % queueSize;	//원형큐, 원소 삭제가 되었으니 front의 값을 +1 해줌
		count--;	//원소 갯수 --
		return item;	//삭제한 값을 반환해줌
	}

} 
