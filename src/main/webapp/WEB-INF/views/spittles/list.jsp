<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
    <!-- 显示用户名 -->
    <h2>Spittle for ${spitter.username}</h2>

    <table cellspacing="15">
        <c:forEach items="${spittleList}" var="spittle">
            <s:url value="/spitters/${spittle.spitter.username}" var="spitter_url"/>
            <tr>
                <td>
                    <img src="<s:url value="/resources/images/spitter_avatar.png"/>" width="48" height="48"/>
                </td>
                <td>
                    <a href="<s:url value="/spitters/${spittle.spitter.username}"/>">${spittle.spitter.username}</a>
                    <c:out value="${spittle.text}"/><br/>
                    <c:out value="${spittle.time}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
