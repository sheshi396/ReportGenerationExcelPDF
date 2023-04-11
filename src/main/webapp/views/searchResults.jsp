<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<table>
  <thead>
    <tr>
      <th>Plan Name</th>
      <th>Plan Status</th>
      <th>Gender</th>
      <th>Plan Start Date</th>
      <th>Plan End Date</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${searchResults}" var="plan">
      <tr>
        <td>${plan.planName}</td>
        <td>${plan.planStatus}</td>
        <td>${plan.gender}</td>
        </tr>
        </c:forEach>
        </tbody>
        </table>
        </body>
        </html>