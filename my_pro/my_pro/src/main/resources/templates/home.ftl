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

                    <#assign cur_date = "">
                    #foreach($vo in $vos)
                    #if ($cur_date != $date.format('yyyy-MM-dd', $vo.news.createdDate))
                        #if ($foreach.index > 0)
                            </div> ## 上一个要收尾
                        #end
                        #set($cur_date = $date.format('yyyy-MM-dd', $vo.news.createdDate))
                    <h3 class="date">
                        <i class="fa icon-calendar"></i>
                        <span>yyc_news &nbsp; <#date.format('yyyy-MM-dd', ${vo.news.createdDate})></span>
                    </h3>

                    <div class="posts">
                    #end
                        <div class="post">
                            <div class="votebar">
                                <button class="click-like up" aria-pressed="false" title="赞同"><i class="vote-arrow"></i><span class="count">$!{vo.news.likeCount}</span></button>
                                <button class="click-dislike down" aria-pressed="true" title="反对"><i class="vote-arrow"></i>
                                </button>
                            </div>
                            <div class="content" data-url="http://nowcoder.com/posts/5l3hjr">
                                <div >
                                    <img class="content-img" src="$!{vo.news.image}" alt="">
                                </div>
                                <div class="content-main">
                                    <h3 class="title">
                                        <a target="_blank" rel="external nofollow" href="$!{vo.news.link}">$!{vo.news.title}</a>
                                    </h3>
                                    <div class="meta">
                                        $!{vo.news.link}
                                        <span>
                                            <i class="fa icon-comment"></i> $!{vo.news.commentCount}
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="user-info">
                                <div class="user-avatar">
                                    <a href="/user/$!{vo.user.id}/"><img width="32" class="img-circle" src="$!{vo.user.headUrl}"></a>
                                </div>

                                <!--
                                <div class="info">
                                    <h5>分享者</h5>

                                    <a href="http://nowcoder.com/u/251205"><img width="48" class="img-circle" src="http://images.nowcoder.com/images/20141231/622873_1420036789276_622873_1420036771761_%E8%98%91%E8%8F%87.jpg@0e_200w_200h_0c_1i_1o_90Q_1x" alt="Thumb"></a>

                                    <h4 class="m-b-xs">冰燕</h4>
                                    <a class="btn btn-default btn-xs" href="http://nowcoder.com/signin"><i class="fa icon-eye"></i> 关注TA</a>
                                </div>
                                -->
                            </div>

                            <div class="subject-name">来自 <a href="/user/$!{vo.user.id}/">$!{vo.user.name}</a></div>
                        </div>

                        <!--
                        <div class="alert alert-warning subscribe-banner" role="alert">
                          《头条八卦》，每日 Top 3 通过邮件发送给你。      <a class="btn btn-info btn-sm pull-right" href="http://nowcoder.com/account/settings">立即订阅</a>
                        </div>
                        -->
                    #if ($foreach.count == $vos.size()) ##最后有个元素要收尾
                    </div>
                    #end

                    #end


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