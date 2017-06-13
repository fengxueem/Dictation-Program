# LetUsProunce

+ **Intro**
	- This is a step by step java(j2se) open source program. You can checkout each commit and find the building procedure.
	- It is a MVC practice using javax.swing package as View, util.mvc.controller as Controller and some class of specifi function as Model.
	- It works as a diction program.
	- This dictation program extracts words from any texts and put them in a word repository which will be the source of dictation.
+ **How to run**
 	1.  Pre-install: [**Eclipse**](https://www.eclipse.org/) + [**Java SE Development Kit**](http://www.oracle.com/technetwork/java/javase/downloads/index.html.)
	2.  Clone/fork/download this project from [**github**](https://github.com/fengxueem/Dictation-Program) to your local storage.
	3.  Open Eclipse -> *File* -> *Import...* -> *General* -> *Existing Projects into Workspace* -> *Select root directory* (this means you need to choose the directory where you just put this project in step 1) -> *Finish*
	4. Run the *"LetUsProunce"* class inside program packge as a java application.
+ **How to use**<br>
*File* -> *Open File...* (Select any txt file from disk)-> *Add* or *Remove*(Add the chosen files to word repo or remove some of them that is unnesessary. Please select these unwanted files from the left list then press remove button, multi-selection is enabled) -> *Dictate* -> *Start* -> *Go* -> *Yes* or *No*(yes, if you know the word; otherwise, no)
+ **Others**
	- You can find a UML sketch in **"UML plan.mdj"**, this "mdj" suffix might confuse you a bit, however, it is the default file type used by a cross-platform UML tool [**StarUML**](https://staruml.io). You should play with it, strongly recommanded. It's free and easy to use.
	- **"MVC design ideas.txt"** is where I wrote my thoughts when I was trying to practice MVC framework. You can read it if you wish or JUST IGNORE it :).
	- **"Dictation_Program.sublime-workspace", "text.txt", "class" and "source"** are built from the very beginning where I tried to use [**Sublime**](http://www.sublimetext.com/) to manage this project, but it turned out Eclipse is just more professional for developing java. So, if you checkout the several very first commits you will find that I was working with Sublime and doing some development on basic ideas like, how to extract words from a txt file, and what kind a word repository will fullfill my future needs. If you only want to see the MVC part, you may not waste your time on them.
+ **Questions & Discussions**<br>
	I am happy to share my thoughts on any questions you may have. 
	Please reach me via: fengxueem@gmail.com
---
+ **简介**<br>
	这是一款用Java编写的听写软件，是我第一次使用MVC的思路完成的。期间用了比较密集的commit，因此可以通过依序查看commit来跟踪整个程序的编写过程。它的主要功能是选择本地txt文件，将其中的所有单词加入单词库中，然后随时可以开始听写。
+ **如何运行** 
 	1.  预安装: [**Eclipse**](https://www.eclipse.org/) + [**Java SE Development Kit**](http://www.oracle.com/technetwork/java/javase/downloads/index.html.)
	2.  Clone/fork/下载该[**github**](https://github.com/fengxueem/Dictation-Program)项目至本地目录A.
	3.  打开 Eclipse -> *File* -> *Import...* -> *General* -> *Existing Projects into Workspace* -> *Select root directory* (选择第一步中的本地目录A) -> *Finish*
	4. 运行program包中的*"LetUsProunce"*类.
+ **如何使用** <br>
*File* ->  *Open File...* (在磁盘上选择你想要听写的txt文件，例如我下载马丁路德金的《I have a dream》放在桌面叫做“I_have_a_dream.txt”)-> *Add* 或者 *Remove*(按下Add后会将刚选中的所有文件导入单词库，按下Remove可以将不需要的文件从白色列表框中删除，先选中列表中不需要的文件后点击Remove，支持多选) -> *Dictate* -> *Start* -> *Go* -> *Yes* or *No*(如果这个单词你认识，yes！如果不熟悉，那就老老实实no吧！)
+ **备注**
	- **"UML plan.mdj"** 里面包含了软件的类结构图，请用[**StarUML**](https://staruml.io)打开，它是在这款软件设计中使用的一款跨平台UML工具。安利一下，很好用。
	- **"MVC design ideas.txt"** 里面是一些设计思路，可以忽略啦～比较早期的设计思路
	- **"Dictation_Program.sublime-workspace", "text.txt", "class" and "source"** 是我一开始用[**Sublime**](http://www.sublimetext.com/) 时的一些文件，在最开始的几次commit当中你可以发现我并没有选择用Eclipse进行开发，事后证明，Eclipse还是要比Sublime做Java来的容易。哈哈，不试不知道嘛～另外，这些里面不包含任何MVC有关内容。
+ **讨论**<br>
	十分欢迎来邮件讨论： fengxueem@gmail.com
