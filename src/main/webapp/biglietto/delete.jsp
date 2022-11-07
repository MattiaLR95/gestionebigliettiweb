<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestionebigliettiweb.model.Biglietto"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Elimina Elemento</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Elimina articolo</h5>
					    </div>
					     <% Biglietto bigliettoDaRimuovere = (Biglietto)request.getAttribute("bigliettoDaRimuovere_attr"); %>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Provenienza</dt>
							  <dd class="col-sm-9">"${bigliettoDaRimuovere_attr.provenienza}"</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Destinazione:</dt>
							  <dd class="col-sm-9">"${bigliettoDaRimuovere_attr.destinazione}"</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Prezzo:</dt>
							  <dd class="col-sm-9">"${bigliettoDaRimuovere_attr.prezzo}"</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data di Arrivo:</dt>
							  <fmt:formatDate value="${bigliettoDaRimuovere_attr.data}" pattern="dd-MM-yyyy" var="dataFormatted"/>
							  <dd class="col-sm-9">"${dataFormatted}"</dd>
					    	</dl>
					    	
					    </div>
					    
					    <div class='card-footer'>
					    	<form action="ExecuteDeleteBigliettoServlet" method="post">
					    		<a href="ListBigliettiServlet" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back
					        	</a>
								
								<div class="col-auto">
    							<button type="submit" class="btn btn-primary mb-3">Remove</button>
    							<input type="hidden" name="idBiglietto" value="<%=bigliettoDaRimuovere.getId() %>">
  								</div>
					    	</form>
					        
					    </div>
					<!-- end card -->
					</div>	
			  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>