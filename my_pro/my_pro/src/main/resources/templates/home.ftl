<!DOCTYPE html>
<html>
    <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>yyc_News</title>
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">


    <link rel="stylesheet" type="text/css" href="/styles/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/styles/font-awesome.min.css">

    <link rel="stylesheet" media="all" href="/styles/style.css">

    <script src="/scripts/hm.js"></script>
    <script src="/scripts/detail.js"></script>

    <script type="text/javascript" src="/scripts/bootstrap.min.js"></script>
    <script type="text/javascript" src="/scripts/jquery.qrcode.min.js"></script>
</head>
<body class="welcome_index">

    <header class="navbar navbar-default navbar-static-top bs-docs-nav" id="top" role="banner">
        <div class="container">
            <div class="navbar-header">
                <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>

                <a href="http://nowcoder.com/" class="navbar-brand logo">
                  <h1>News</h1>
                  <h3>Today News is over here</h3>
                </a>
            </div>

            <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">

                <ul class="nav navbar-nav navbar-right">
                    <li class=""><a href="http://nowcoder.com/explore">发现</a></li>

                    <li><a href="http://nowcoder.com/signin">站内信</a></li>
                    <li class=""><a href="http://nowcoder.com/about">登陆</a></li>
                </ul>

            </nav>
        </div>
    </header>

    <div id="main">


        <div class="container" id="daily">
            <div class="jscroll-inner">
                <div class="daily">

                </div>

                <h3 class="date">
                    <i class="fa icon-calendar"></i>
                    <span>头条资讯 &nbsp; ${.now}</span>
                </h3>

                <div class="posts">
                    <#list vo_list as vo>

                    <div class="post">
                        <div class="votebar">
                            <button class="click-like up" aria-pressed="false" title="赞同"><i class="vote-arrow"></i>${vo.n.getLike_count()}<span class="count"></span></button>
                            <button class="click-dislike down" aria-pressed="true" title="反对"><i class="vote-arrow"></i>
                            </button>
                        </div>
                        <div class="content" data-url="http://nowcoder.com/posts/5l3hjr">
                            <div >
                                <img class="content-img" src="${vo.n.getImage()}" alt="">
                            </div>
                            <div class="content-main">
                                <h3 class="title">
                                    <a target="_blank" rel="external nofollow" href="${vo.n.getLink()}">${vo.n.title}</a>
                                </h3>
                                <div class="meta">

                                    <span>
                                            <i class="fa icon-comment"></i> ${vo.n.getComment_count()}
                                        </span>
                                </div>
                            </div>
                        </div>
                        <div class="user-info">
                            <div class="user-avatar">
                            </div>
                        </div>

                        <div class="subject-name">来自</a></div>
                    </div>
                    </#list>


                </div>


            </div>
        </div>
    </div>

    </div>

    </div>

    <footer>
        <div class="container">
            <p class="text-center">
                <a href="http://nowcoder.com/about">关于我们</a>
                <a href="http://nowcoder.com/download">客户端</a>
            </p>
            <p class="text-center">----</p>
        </div>

    </footer>

  <div id="quick-download">
        <button type="button" class="close-link btn-link" data-toggle="modal" data-target="#quick-download-app-modal"><i class="fa icon-times-circle"></i></button>


  </div>

  <script>
  </script>


</body></html>