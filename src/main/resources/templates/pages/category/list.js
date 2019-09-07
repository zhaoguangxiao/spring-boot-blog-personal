<!--<script type="text/javascript">-->
<!--    (function () {-->
<!--        window.TypechoComment = {-->
<!--            dom: function (id) {-->
<!--                return document.getElementById(id);-->
<!--            },-->

<!--            create: function (tag, attr) {-->
<!--                var el = document.createElement(tag);-->

<!--                for (var key in attr) {-->
<!--                    el.setAttribute(key, attr[key]);-->
<!--                }-->

<!--                return el;-->
<!--            },-->

<!--            reply: function (cid, coid) {-->
<!--                var comment = this.dom(cid), parent = comment.parentNode,-->
<!--                    response = this.dom('respond-page-14'), input = this.dom('comment-parent'),-->
<!--                    form = 'form' == response.tagName ? response : response.getElementsByTagName('form')[0],-->
<!--                    textarea = response.getElementsByTagName('textarea')[0];-->

<!--                if (null == input) {-->
<!--                    input = this.create('input', {-->
<!--                        'type': 'hidden',-->
<!--                        'name': 'parent',-->
<!--                        'id': 'comment-parent'-->
<!--                    });-->

<!--                    form.appendChild(input);-->
<!--                }-->

<!--                input.setAttribute('value', coid);-->

<!--                if (null == this.dom('comment-form-place-holder')) {-->
<!--                    var holder = this.create('div', {-->
<!--                        'id': 'comment-form-place-holder'-->
<!--                    });-->

<!--                    response.parentNode.insertBefore(holder, response);-->
<!--                }-->

<!--                comment.appendChild(response);-->
<!--                this.dom('cancel-comment-reply-link').style.display = '';-->

<!--                if (null != textarea && 'text' == textarea.name) {-->
<!--                    textarea.focus();-->
<!--                }-->

<!--                return false;-->
<!--            },-->

<!--            cancelReply: function () {-->
<!--                var response = this.dom('respond-page-14'),-->
<!--                    holder = this.dom('comment-form-place-holder'), input = this.dom('comment-parent');-->

<!--                if (null != input) {-->
<!--                    input.parentNode.removeChild(input);-->
<!--                }-->

<!--                if (null == holder) {-->
<!--                    return true;-->
<!--                }-->

<!--                this.dom('cancel-comment-reply-link').style.display = 'none';-->
<!--                holder.parentNode.insertBefore(response, holder);-->
<!--                return false;-->
<!--            }-->
<!--        };-->
<!--    })();-->
<!--</script>-->
<!--<script type="text/javascript">-->
<!--    (function () {-->
<!--        var event = document.addEventListener ? {-->
<!--            add: 'addEventListener',-->
<!--            triggers: ['scroll', 'mousemove', 'keyup', 'touchstart'],-->
<!--            load: 'DOMContentLoaded'-->
<!--        } : {-->
<!--            add: 'attachEvent',-->
<!--            triggers: ['onfocus', 'onmousemove', 'onkeyup', 'ontouchstart'],-->
<!--            load: 'onload'-->
<!--        }, added = false;-->

<!--        document[event.add](event.load, function () {-->
<!--            var r = document.getElementById('respond-page-14'),-->
<!--                input = document.createElement('input');-->
<!--            input.type = 'hidden';-->
<!--            input.name = '_';-->
<!--            input.value = (function () {-->
<!--                var _Sng = /* 'Rp'//'Rp' */'' + 'aa'//'Q'-->
    <!--                    + '72f'//'t'-->
    <!--                    +//'CE'-->
    <!--                    '0be' + '4'//'DTa'-->
    <!--                    + '97'//'2q4'-->
    <!--                    +//'v9'-->
    <!--                    'b2d' +//'H'-->
    <!--                    '3' + ''///*'H'*/'H'-->
    <!--                    +//'J'-->
    <!--                    '3' +//'7q'-->
    <!--                    'a' +//'ayU'-->
    <!--                    '9cc' + 'a'//'oT'-->
    <!--                    +//'5'-->
    <!--                    '5' +//'z1'-->
    <!--                    'z1' + '4d6'//'VXn'-->
    <!--                    +//'WhO'-->
    <!--                    '53' + 'a8'//'W'-->
    <!--                    + ''///*'CP'*/'CP'-->
    <!--                    +/* 'Qh'//'Qh' */'' + '7'//'2'-->
    <!--                    + ''///*'Y'*/'Y'-->
    <!--                    + ''///*'5j'*/'5j'-->
    <!--                    +//'7'-->
    <!--                    '7f0', _uV1 = [[21, 22], [21, 23]];-->

    <!--                for (var i = 0; i < _uV1.length; i++) {-->
    <!--                    _Sng = _Sng.substring(0, _uV1[i][0]) + _Sng.substring(_uV1[i][1]);-->
    <!--                }-->

    <!--                return _Sng;-->
    <!--            })();-->

    <!--            if (null != r) {-->
    <!--                var forms = r.getElementsByTagName('form');-->
    <!--                if (forms.length > 0) {-->
    <!--                    function append() {-->
    <!--                        if (!added) {-->
    <!--                            forms[0].appendChild(input);-->
    <!--                            added = true;-->
    <!--                        }-->
    <!--                    }-->

    <!--                    for (var i = 0; i < event.triggers.length; i++) {-->
    <!--                        var trigger = event.triggers[i];-->
    <!--                        document[event.add](trigger, append);-->
    <!--                        window[event.add](trigger, append);-->
    <!--                    }-->
    <!--                }-->
    <!--            }-->
    <!--        });-->
    <!--    })();-->
    <!--</script>-->