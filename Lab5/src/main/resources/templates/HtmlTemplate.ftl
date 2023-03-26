<!DOCTYPE html>
<html>
<head>
  <title>${title}</title>
</head>
<body>
  <h1>${title}</h1>

  <p>${catalog.name}</p>

  <ul>
    <#list documentList as document>
      <li>${document_index + 1}. ${document} </li>
    </#list>
  </ul>

</body>
</html>