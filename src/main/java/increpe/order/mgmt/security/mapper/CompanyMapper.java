package increpe.order.mgmt.security.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import increpe.order.mgmt.model.Activity;
import increpe.order.mgmt.model.ActivityMaster;
import increpe.order.mgmt.model.Attendance;
import increpe.order.mgmt.model.Company;
import increpe.order.mgmt.model.CompanyProduct;
import increpe.order.mgmt.model.CompanyTypeRelation;
import increpe.order.mgmt.model.CompanyUserRelation;
import increpe.order.mgmt.model.CustomerSalesPersonRelation;
import increpe.order.mgmt.model.Emails;
import increpe.order.mgmt.model.Expenses;
import increpe.order.mgmt.model.Order;
import increpe.order.mgmt.model.OrderDetails;
import increpe.order.mgmt.model.Phone;
import increpe.order.mgmt.model.ProductMaster;
import increpe.order.mgmt.model.SalesPerson;
import increpe.order.mgmt.model.Tour;
import increpe.order.mgmt.model.Visits;
import increpe.order.mgmt.model.WorkAreaMaster;
import increpe.order.mgmt.security.dto.CompanyDto;
import increpe.order.mgmt.security.dto.CompanyProductDto;
import increpe.order.mgmt.security.dto.CompanyTypeRelationDto;
import increpe.order.mgmt.security.dto.CompanyUserRelationDto;
import increpe.order.mgmt.security.dto.CustomerSalesPersonRelationDto;
import increpe.order.mgmt.security.dto.EmailsDto;
import increpe.order.mgmt.security.dto.OrderDetailsDto;
import increpe.order.mgmt.security.dto.OrderDto;
import increpe.order.mgmt.security.dto.PhonesDto;
import increpe.order.mgmt.security.dto.ProductMasterDto;
import increpe.order.mgmt.security.dto.RegistrationRequest;
import increpe.order.mgmt.security.dto.SalesPersonDto;
import increpe.order.mgmt.security.dto.WorkAreaMasterDto;
import increpe.order.mgmt.sp.dto.ActivityDto;
import increpe.order.mgmt.sp.dto.ActivityMasterDto;
import increpe.order.mgmt.sp.dto.AttendanceDto;
import increpe.order.mgmt.sp.dto.ExpensesDto;
import increpe.order.mgmt.sp.dto.TourDto;
import increpe.order.mgmt.sp.dto.VisitsDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {

	CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

	Company convertToCompany(CompanyDto companyDto);

	CompanyDto convertToCompanyDto(Company company);

	CompanyTypeRelationDto convertToCompanyTypeRelationDto(RegistrationRequest registrationRequest);

	CompanyTypeRelation convertToCompanyTypeRelation(CompanyTypeRelationDto companyTypeRelationDto);

	CompanyTypeRelationDto convertToCompanyTypeRelationDto(CompanyTypeRelation companyTypeRelation);

	CompanyUserRelation convertToCompanyUserRelation(CompanyUserRelationDto companyUserRelationDto);

	CompanyUserRelationDto convertCompanyUserRelationDto(CompanyUserRelation companyUserRelation);

	List<CompanyUserRelationDto> convertToCompanyUserRelationDtoList(List<CompanyUserRelation> relationList);

	WorkAreaMasterDto convertToWorkAreaMasterDto(WorkAreaMaster workAreaMaster);

	WorkAreaMaster convertToWorkAreaMaster(WorkAreaMasterDto workAreaMasterDto);

	List<WorkAreaMasterDto> convertToWorkAreaMasterDtoList(List<WorkAreaMaster> masterList);

	List<WorkAreaMaster> convertToWorkAreaMasterList(List<WorkAreaMasterDto> masterDtoList);

	ProductMaster convertToProductMaster(ProductMasterDto masterDto);

	ProductMasterDto convertToProductMasterDto(ProductMaster productMaster);

	List<ProductMasterDto> convertToProductMasterDtoList(List<ProductMaster> masterList);

	List<ProductMaster> convertToProductMasterList(List<ProductMasterDto> masterDtoList);

	CompanyProductDto convertToCompanyProductDto(CompanyProduct cProduct);

	CompanyProduct convertToCompanyProduct(CompanyProductDto cProductDto);

	List<CompanyProductDto> convertToCompanyProductDtoList(List<CompanyProduct> masterList);

	List<CompanyProduct> convertToCompanyProductList(List<CompanyProductDto> masterDtoList);

	SalesPersonDto convertToSalesPersonDto(SalesPerson salesPerson);

	SalesPerson convertToSalesPerson(SalesPersonDto salesPersonDto);

	EmailsDto convertToEmailsDto(Emails email);

	Emails convertToEmails(EmailsDto emailDto);

	PhonesDto convertToPhonesDto(Phone phone);

	Phone convertToPhone(PhonesDto phonesDto);

	CustomerSalesPersonRelationDto convertToCustomerSalesPersonRelationDto(CustomerSalesPersonRelation relation);

	CustomerSalesPersonRelation convertToCustomerSalesPersonRelation(CustomerSalesPersonRelationDto relationDto);

	List<CustomerSalesPersonRelationDto> convertToCustomerSalesPersonRelationDtoList(
			List<CustomerSalesPersonRelation> relationList);

	List<CustomerSalesPersonRelation> convertToCustomerSalesPersonRelationList(
			List<CustomerSalesPersonRelationDto> relationDtoList);

	Visits convertToVisits(VisitsDto visitsDto);

	VisitsDto convertToVisitsDto(Visits visit);

	List<Visits> convertToVisitsList(List<VisitsDto> visitsDtoList);

	List<VisitsDto> convertToVisitsDtoList(List<Visits> visitsList);

	Expenses convertToExpenses(ExpensesDto eDto);

	ExpensesDto convertToExpensesDto(Expenses expense);

	List<Expenses> convertToExpensesList(List<ExpensesDto> expensesDtoList);

	List<ExpensesDto> convertToExpensesDtoList(List<Expenses> expensesList);

	Attendance convertToAttendance(AttendanceDto aDto);

	AttendanceDto convertToAttendanceDto(Attendance attendance);

	List<Attendance> convertToAttendanceList(List<AttendanceDto> attendanceDtoList);

	List<AttendanceDto> convertToAttendanceDtoList(List<Attendance> attendanceList);

	Order convertToOrder(OrderDto orderDto);

	OrderDto convertToOrderDto(Order order);

	OrderDetails convertToOrderDetails(OrderDetailsDto detailsDto);

	OrderDetailsDto convertToOrderDetailsDto(OrderDetails orderDetails);

	List<Order> convertToOrderList(List<OrderDto> orderDtoList);

	List<OrderDto> convertToOrderDtoList(List<Order> orderList);
	
	List<OrderDetails> convertToOrderDetailsList(List<OrderDetailsDto> detailsDtoList);

	List<OrderDetailsDto> convertToOrderDetailsDtoList(List<OrderDetails> orderDetailsList);
	
	Tour convertToTour(TourDto tourDto);

	TourDto convertToTourDto(Tour tour);

	List<Tour> convertToTourList(List<TourDto> tourDtoList);

	List<TourDto> convertToTourDtoList(List<Tour> tourList);
	
	Activity convertToActivity(ActivityDto activityDto);

	ActivityDto convertToActivityDto(Activity activity);

	List<Activity> convertToActivityList(List<ActivityDto> activityDtoList);

	List<ActivityDto> convertToActivityDtoList(List<Activity> activityList);
	
	ActivityMaster convertToActivityMaster(ActivityMasterDto activityMasterDto);

	ActivityMasterDto convertToActivityMasterDto(ActivityMaster activityMaster);

	List<ActivityMaster> convertToActivityMasterList(List<ActivityMasterDto> activityMasterDtoList);

	List<ActivityMasterDto> convertToActivityMasterDtoList(List<ActivityMaster> activityMasterList);

	@AfterMapping
	default void convertToVisitsDto(Visits visit, @MappingTarget VisitsDto visitsDto) {

		if (Objects.isNull(visit.getVisitDate())) {
			visitsDto.setVisitDate(LocalDate.now(ZoneId.of("IST", ZoneId.SHORT_IDS)));
			;
		}
		if (Objects.isNull(visit.getVisitTime())) {
			visitsDto.setVisitTime(LocalTime.now(ZoneId.of("IST", ZoneId.SHORT_IDS)));
		}
	}

	@AfterMapping
	default void convertToVisits(VisitsDto visitsDto, @MappingTarget Visits visit) {

		if (Objects.isNull(visitsDto.getVisitDate())) {
			visit.setVisitDate(LocalDate.now(ZoneId.of("IST", ZoneId.SHORT_IDS)));
		}
		if (Objects.isNull(visitsDto.getVisitTime())) {
			visit.setVisitTime(LocalTime.now(ZoneId.of("IST", ZoneId.SHORT_IDS)));
		}
	}

	@AfterMapping
	default void convertToAttendanceDto(Attendance attendance, @MappingTarget AttendanceDto attendanceDto) {

		if (Objects.isNull(attendance.getStartTime())) {

			attendanceDto.setStartTime(LocalDateTime.now(ZoneId.of("IST", ZoneId.SHORT_IDS)));
		}
		if (Objects.isNull(attendance.getEndTime())) {

			LocalDate today = LocalDate.now(ZoneId.of("IST", ZoneId.SHORT_IDS));

			attendanceDto.setEndTime(LocalDateTime.of(today, LocalTime.of(23, 59, 59)));
		}
	}

	@AfterMapping
	default void convertToAttendance(AttendanceDto attendanceDto, @MappingTarget Attendance attendance) {

		if (Objects.isNull(attendanceDto.getStartTime())) {
			attendance.setStartTime(LocalDateTime.now(ZoneId.of("IST", ZoneId.SHORT_IDS)));
		}
		if (Objects.isNull(attendanceDto.getEndTime())) {

			LocalDate today = LocalDate.now(ZoneId.of("IST", ZoneId.SHORT_IDS));

			attendance.setEndTime(LocalDateTime.of(today, LocalTime.of(23, 59, 59)));
		}
	}
}
