# AI_Block

프로젝트 기간 2022.09~2023.1 
(Opencv, Yolov4 Custom file, tensorflow lite, Android을 경험했던 프로젝트)

아쉽게도 제대로된 구현은 실패 (첫프로젝트라 다양한 경험을 할 수 있어 좋았지만 미흡한 점이 많았음)
실패원인 : 오픈소스 활용 안드로이드 구현능력 부족으로 인한 제출기한 도과

![1](https://user-images.githubusercontent.com/92626903/213448450-a792fca7-b465-41f6-8714-34dbc8125b42.PNG)

![캡처](https://user-images.githubusercontent.com/92626903/213448478-13cb86c6-4686-4aa4-86f6-431bb929f671.PNG)

![3](https://user-images.githubusercontent.com/92626903/213448503-afcf1dd1-c28a-4e71-bb7e-53f79849d416.PNG)

![4](https://user-images.githubusercontent.com/92626903/213448537-9345d320-3967-4a9d-895b-a25d8391ca38.PNG)



--과정--
1학년임에도 불구하고 교수님의 선의로 프로젝트에 참여 할 수 있게 되었다.  
프로젝트에 참여한다는게 처음 경험하는거라 그 당시에 설렘과 긴장감에 부풀어 있었던 것 같다. 걱정반,기대반![](https://velog.velcdn.com/images/mnl124/post/1ed28405-28f4-49e7-8cde-f7c0a0fcfd62/image.png)


3학년 학교 선배와 함께 진행한다하여 아무것도 모르는 내가 민폐가 되지는 않을까 걱정하기도 했다. 

프로젝트 주제는 4D-Frame 교구재를 활용한 아이디어 산출이다.![](https://velog.velcdn.com/images/mnl124/post/8f4d30a8-29f6-4b6a-8ecd-1a392e34886e/image.jpeg)
우리가 생각한 프로젝트 아이디어는 유치원, 초등학교 저학년들이 이 교구재로 모형을 만들어 휴대폰으로 사진을 찍는다면 그 모형에 해당하는 코드기능이 나와 코드를 짜게 해줌으로써 FlowChart 설계능력을 길러 줄 수 있는 어플을 만드는 것이였다.

![](https://velog.velcdn.com/images/mnl124/post/a353eaae-f32c-45eb-88d0-9895d146840d/image.png)
모두가 함께하는 프로젝트이기에  개발환경도 서로 맞추었다. 
언어 : Python3.9.1, JAVA 
개발Tool : Android studio, Anaconda, Visual StudioCode 
딥러닝 이미지처리 : OpenCV Yolov4, Tensorflow 2.3 
이미지 라벨링작업Tool : Yolo mark , labelimg

![](https://velog.velcdn.com/images/mnl124/post/3d1d8ea0-228d-4629-a7f6-cf65ebf36105/image.png)

파이썬을 처음 접하는 인원들도 있어 프로젝트를 위해 언어를 빨리 훑어보기도 했다.
또한 OpenCV라는 컴퓨터비전 라이브러리를 이용하기위해 Yolo라는것에대해 공부하기도했다. 
유튜브와 구글링해서 나온 각종 블로그들의 자료들로...
![](https://velog.velcdn.com/images/mnl124/post/b7ff7ae5-0a26-4fde-8765-a2f6a95099db/image.png)
초반에 안드로이드 담당하신 선배분이 건강상 참여가 어려워져 서로서로 과제를 부여하면서 안드로이드 공부를 독려하기도 했다. 
![](https://velog.velcdn.com/images/mnl124/post/ab1d9143-eb62-4ef8-9d06-2b50eee960e1/image.png)
다행히 교수님의 노력으로 안드로이드를 같이 만들 새로운 선배분들이 투입되었다.

먼저 나는 데이터셋 구축하는 팀에 속하게 되었다.
교구재로 만든 도형을 어떤식으로 코드기능을 부여할지 의견을 나누어 정하였고 

MVP식으로 코드기능에 따른 모형을 몇가지만 간단히 정하고 학습 모델을 빨리 만들어보기로했다.
(커스텀해서 만든 모델의 도형 인식률이 어떻게 나올지 확실하지 않았기때문에) 

![](https://velog.velcdn.com/images/mnl124/post/58e7bc88-f311-423d-bb92-17bebf020ac2/image.png)
위 사진은 한가지 색깔로 통일해서 정리한 코드 기능(초기)제안서이다.

교구재의 빨대는 다양한 색깔과 길이, 다리모양 존재해 한 모양에 대해 여러가지 사안들을 학습시켜 
어떠한 색깔, 길이의 빨대로 조합해서 모양을 만들더라도 인식될 수 있도록 했어야했다. 
인식률이 정말 중요했다. 
먼저 한 모양에대해 500장씩 학습시켰는데
정확도가 낮아 500장 더해 1000장식 학습시켰다.
12개 클래스로 총 만장여 사진을 찍었다.


![](https://velog.velcdn.com/images/mnl124/post/6308cf98-3d1f-4137-987e-aece2ff69f26/image.png)

수 많은 사진에 직접 각 도형에 라벨링을 했어야 했기때문에 정말 노가다였다..

![](https://velog.velcdn.com/images/mnl124/post/4d1dbd22-15c9-4ff4-842f-c227f8dcdc05/image.png)
위 사진은 객체인식 모델을 실행한 결과로 1에 가까울 수록 인식률이 높다는 것을 의미한다.


![](https://velog.velcdn.com/images/mnl124/post/4ad97853-0736-4b28-8dcc-3008a7dbe8a4/image.png)

모양을 코드로 구현해서 창작하여 만든다는게 생각보다 쉽지 않았다.
그래서 회의나 카톡으로 수많은 아이디어를 생각해내기위해 노력했다.

다음으로 우리가 학습한 모델을 안드로이드에 탑재 할 수 있는지 구글링해서 찾아보았다.

텐서플로우를 이용하면 openCV Yolov4 가중치모델을 안드로이드에 적용 할 수 있다는 외국인 블로그의 말에 텐서플로우를 공부하기 시작했다.
서점에서 관련 서적을 찾아 구매도 했다....
![](https://velog.velcdn.com/images/mnl124/post/bbcf37a7-0945-40dc-b373-0bfd585a2c89/image.jpeg)


먼저 Yolov4 weights가중치 모델을 tensorflow(.pb) 형식으로 변환하고 거기서 모바일에 탑재할 수 있게 tflite라는 파일로 최종 변환해야했다. 

https://github.com/haroonshakeel/tensorflow-yolov4-tflite
(Convert Darknet YOLOv4 or YOLOv3 to TensorFlow Model 할 수 있는 사이트) 

역시 변환과정이 순탄하지 않았다.

내가만난 오류 
ValueError: cannot reshape array of size 793191 into shape ![](https://velog.velcdn.com/images/mnl124/post/2dfc8328-fce6-43f1-95d8-980fe8e328b1/image.jpeg)
이 문제를 해결하기위해 하루종일 카페에서 구글링했다... 

GitHub에서 issues 관련 내용도 찾아보고
https://github.com/hunglc007/tensorflow-yolov4-tflite/issues/396

수 많은 외국이들이 모인 Stack Overflow에서 관련한 오류를 물어보기도 했다.

![](https://velog.velcdn.com/images/mnl124/post/5408cb4f-9503-4b03-ba6a-980e9ee77fdc/image.png)

다행히 스택오버플로우에서 문제에대한 해결을 찾을 수 있었다. https://stackoverflow.com/questions/67496720/converting-yolov4-tiny-to-tflite-errorcannot-reshape-array-of-size-372388-into

![](https://velog.velcdn.com/images/mnl124/post/1d4685c5-c688-4f9f-9426-26a631160231/image.png)
(OpenCV YoloV4 weights 파일을 tensorflow (.pb)로 변환해 나타난 결과창) 
여기서 한번더 tflite로 변환 할 수 있는 명령을 이용해 최종 변환파일을 생성했다.
![](https://velog.velcdn.com/images/mnl124/post/dd0a1244-6be0-41b1-872e-6ea31e7d537a/image.png)


https://velog.io/@mnl124/%EB%82%B4%EA%B0%80-%EC%9D%B4%ED%95%B4%ED%95%9C-yolo-tiny%ED%8C%8C%EC%9D%BC-%ED%85%90%EC%84%9C%ED%94%8C%EB%A1%9C%EC%9A%B0-%EB%B3%80%ED%99%98%EA%B3%BC%EC%A0%95
(YoloV4 가중치를 tflite 변환하는 과정을 정리)

이제 이 파일을 안드로이드에 넣기만하면 인공지능 이미지 인식 기능을 구현할 수 있다하여 

텐서플로우 라이트를 이용한 이미지 분류 안드로이드앱을 구축를 시도했다.

일단 나는 이 학습한 모델일 제대로 돌아가는지 확인하기 위해 인도인이 만든 앱을 따라 만들어 보았다.
https://www.youtube.com/watch?v=tySgZ1rEbW4

어플에서 사진을 찍고 해당하는 모형이름과 인식률이 밑에 떠야하는데 ..... 사진찍고 불러오는 과정에 팅기는 오류에 마주쳤다. 

![](https://velog.velcdn.com/images/mnl124/post/fc759947-55dc-4081-869d-8c7fbfb5d0c7/image.png)

바이트 버퍼???? 사이즈...??? 맞지 않다고? 무슨소리지.. 문제해결을 위해

https://www.tensorflow.org/lite/api_docs/java/org/tensorflow/lite/support/tensorbuffer/TensorBuffer

텐서플로우 문서를 찾아보기도 했는데 이해가 되지 않았다...

오버스택플로우에다가 질문해보면 친절한 외국인들이 알려주지 않을까하여 또 글을 올리기도 했다.

![](https://velog.velcdn.com/images/mnl124/post/091f7751-9dba-4218-9866-7e1ca72cb7e0/image.png)

음... 아무도 답변해주지 않았다...

![](https://velog.velcdn.com/images/mnl124/post/4537cefd-7150-4231-8388-d141eb38beab/image.png)

그렇게... 아까운 시간들이 흘렀고,

https://wiserloner.tistory.com/1380


![](https://velog.velcdn.com/images/mnl124/post/37b143ac-6981-4970-a908-a57aab005855/image.png)
커스텀해서 학습한 tflite모델을 분석해보는등 여러 노력을 해봤다.


![](https://velog.velcdn.com/images/mnl124/post/edeaa128-dc32-4682-8f77-82e00c6d6b5f/image.png)

관련해서 전문가를 찾고 오류 관련하여 이메일을 보내봤지만 아쉽게도 답장은 오지 않았고 프로젝트는 미궁쏙으로 빠지기 시작했다. ㅠㅠ

일단 교수님께서 UI디자인부터 해보자하여 
PPT로 스토리보드도 짜보고 각 화면에서 어떠한 기능이 필요할지 여러 회의를 해보고 구현하기도 했다.

![](https://velog.velcdn.com/images/mnl124/post/4c6ba2c7-20b4-4162-9f49-786df6856ec6/image.png)

교수님께서 시스템분석 및 설계에 대해 도안짜는 방법을 알려주셨고 strUML이라는 Tool도 알게되었다.

사진찍고 추론과정에서 팅기는게 코드 문제일 수도 있어, 

교수님께서 프레임워크를 통한 이미지 분류앱 구축하는 PDF자료를 구해서 올려주셨고 나머지 안드로이드 개발 인원들은 그 PDF에 따라 앱을 구축하기로 했다.

하지만 그 PDF토대로 만든 이미지 분류 앱도 우리가 커스텀해서 학습한 모델이 적용되지 않았다... 더군다나 이번엔 다른 오류가 생겼다.

![](https://velog.velcdn.com/images/mnl124/post/eb525162-0898-48e4-b423-0cb7be61b674/image.png)

학습한 클래스의 라벨과 순서가 맞지 않다는 오류였다... 

이것또한 구글링를 통해 각종 문서들을 다 찾아봤지만 관련한 내용들이 정말 몇 페이지밖에 없었다.
이건 정말 해결할 수 없는 것 인가...?

어떤 자료에서 tflite 이미지 분류 모델에서 학습한 0번째 클래스는 무시된다고하여 이게 문제일수도 있을 것 같아 

다시... 라벨링을 0번째 없이 1번부터하여 모델을 학습하고 변환과정을 거쳐 만들었지만 역시나 해결되지 않았다.

우리가 커스텀한 모델은 추론이 되지를 않았지만 PDF에서 ImageNet이라는 모델을 사용했었는데 그 모델을 가져다 쓴 결과 어플에서 팅기는 현상없이 해당 이미지에 대한 추론과 인식률이 잘 나왔다.

![](https://velog.velcdn.com/images/mnl124/post/b85d685e-71d8-448d-968a-1bc225e38a17/image.png)

잘 작동되는 샘플데이터(ImageNet)를 추출해 분석해보았고 우리가 학습한 커스텀 데이터(모델)하고 애초에 사이즈가 다르게 나왔다.

여기서 나온 사이즈 값들이 무엇을 의미하는지 파악하기위해 구글링을 했고 
![](https://velog.velcdn.com/images/mnl124/post/c7a6d94d-17a5-434c-887f-86cca905a116/image.png)
오랜 시간끝에 왜 안되었는지에 대한 이유와 문제해결방안을 찾게 되었다.

https://dacon.io/forum/405930
(코코데이터셋관련내용 참고 블로그)

https://medium.com/ddiddu-log/%EC%9D%B4%EB%AF%B8%EC%A7%80-%EC%9D%B8%EC%8B%9D%EC%9D%98-%EC%A0%95%EC%9D%98%EC%99%80-%EC%A3%BC%EC%9A%94-%EB%AA%A8%EB%8D%B8-%EB%B9%84%EA%B5%90-1-%EC%9D%B4%EB%AF%B8%EC%A7%80-%EB%B6%84%EB%A5%98-image-classification-ae7a59bfaf65
(이미지분류내용관련 참고블로그)

인공지능에 대한 기본적인 지식만 있었더라면 이러한 문제로인해 오랜시간을 질질 끌 필요가 없었을텐데.... 

삽질을 정말 오래했고 내가 능력부족인 것 같아 무기력,우울함 번아웃증후군같은 증상이 오기도 했다. 

결국 오류는 단순한거였다. 우리가 커스텀해서 학습한 AI모델은 객체인식을위한 모델이였고... 안드로이드 어플을 만든건 이미지 분류기능을 위해 학습한 모델일 필요했던것이었다.

https://colab.research.google.com/github/tensorflow/tensorflow/blob/master/tensorflow/lite/g3doc/models/modify/model_maker/image_classification.ipynb#scrollTo=TUfAcER1oUS6

다시 텐서플로우로 이미지분류 모델을 학습시키기 위해 한 사진에 도형하나만 나오게 사진을 다시 찍었고 텐서플로우 공식문서에있는 방식으로 학습을 시켜서 모델을 만들었다.

![](https://velog.velcdn.com/images/mnl124/post/3888d2db-5e8f-4518-86cf-d943378ee733/image.png)


![](https://velog.velcdn.com/images/mnl124/post/ef602cf9-519c-46ed-9cf5-9b61305b0cf5/image.png)

위 사진은 여러가지 도형을 추론한 결과값이고 빨간색이 추론이 틀린 것을 의미한다.

![](https://velog.velcdn.com/images/mnl124/post/ff229fe0-2f7d-4b8d-86e6-1827dc1d357c/image.png)

다행히 우리가 커스텀한 모델이 안드로이드 어플리케이션 추론과정에서 팅기지 않고 정상작동하여 인식률이 잘 나왔다.

**와 .... 결국에는 어떤게 문제인지 분석하고 여러 시행착오를 통해 노력을 하면
마침내 문제해결이 된다는 깨닫게되었다.
학교프로젝트에서 이러한 경험을 할 수 있어서 정말 값진 경험이었던 것 같다. 
학교프로젝트의 장점은 오류가 있어도 충분한 시간을 통해 파고들수 있다 것이다. 
돈받고 일하는 회사였다면... 다른 사람이 해결해버리고 나는 손도 못대보고 끝났을 것이다. **

**변환과정... AI, 버퍼사이즈, 객체인식, 이미지 분류, OpenCV, Yolo, 구글코랩, 쥬피터, 안드로이드등등 여러가지를 배울 수 있어서 정말 좋았던 것 같다.
**



이제는 이 도형을 토대로 안드로이드에서 어떻게 코드생성하는 로직을 짤지 생각해봐야겠다. 

전문인공지능강사님하고 줌 회의한 과정

<img width="829" alt="KakaoTalk_Photo_2023-01-19-22-07-06" src="https://user-images.githubusercontent.com/92626903/213451125-ae24ec0c-2da7-483e-aa9d-438b535d5756.png">

<img width="907" alt="KakaoTalk_Photo_2023-01-19-22-07-12" src="https://user-images.githubusercontent.com/92626903/213451248-a0de597c-2d00-4d42-8cf1-9bc9c10c3c28.png">
